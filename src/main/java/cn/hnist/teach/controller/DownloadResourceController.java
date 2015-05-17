package cn.hnist.teach.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.hnist.teach.entity.DownloadResource;
import cn.hnist.teach.entity.DownloadResourceType;
import cn.hnist.teach.entity.ResourceSrc;
import cn.hnist.teach.service.inter.IDownloadResourceService;
import cn.hnist.teach.service.inter.IDownloadResourceTypeService;
import cn.hnist.teach.service.inter.IResourceSrcService;

@Controller
public class DownloadResourceController {
	
	@Resource
	private IDownloadResourceService downloadResourceService;
	
	@Resource
	private IDownloadResourceTypeService downloadResourceTypeService;
	
	@Resource
	private IResourceSrcService resourceSrcService;
	
	@RequestMapping("admin/findDownloadResources")
	public String findDownloadResources(Integer pageNumber, Integer pageSize, Model model){
		if(null == pageNumber){
			pageNumber = 1;
		}
		if(null == pageSize){
			pageSize = 10;
		}
		Page<DownloadResource> page = downloadResourceService.findAll(new PageRequest(pageNumber-1, pageSize));		
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_download_resource";
	}
	
	@RequestMapping("admin/addDownloadResource")
	public String addDownloadResource(Model model){
		List<DownloadResourceType> types = (List<DownloadResourceType>) downloadResourceTypeService.findAll();
		model.addAttribute("types", types);
		return "admin/add_download_resource";
	}
	
	@RequestMapping("admin/saveDownloadResource")
	public String saveDownloadResource(DownloadResource downloadResource,@RequestParam MultipartFile resFile,HttpServletRequest request) throws IllegalStateException, IOException{
		String realPath = request.getServletContext().getRealPath("static")+File.separator+"upload"+File.separator+"file";
		if(null != resFile && !"".equals(resFile.getOriginalFilename())){
			UUID uuid = UUID.randomUUID();
			//文件真实名字
			String fileName = resFile.getOriginalFilename();
			//保存磁盘的文件的名字
			String name = uuid.toString()+fileName.substring(fileName.lastIndexOf("."));
			resFile.transferTo(new File(realPath +File.separator+ name));
			downloadResource.setDatetime(new Date());
			downloadResource.setCount(0L);
			downloadResource.setRealName(fileName);
			downloadResource.setName(name);
			
		}else{
			DownloadResource downloadResource2 = downloadResourceService.findOne(downloadResource.getId());
			downloadResource.setName(downloadResource2.getName());
			downloadResource.setRealName(downloadResource2.getRealName());
			downloadResource.setCount(downloadResource2.getCount());
			downloadResource.setDatetime(downloadResource2.getDatetime());
		}
		downloadResourceService.save(downloadResource);
		return "redirect:/admin/findDownloadResources";
	}
	
	@RequestMapping("admin/updateDownloadResource")
	public String updateDownloadResource(Integer id,Model model){
		DownloadResource downloadResource = downloadResourceService.findOne(id);
		model.addAttribute(downloadResource);
		List<DownloadResourceType> types = (List<DownloadResourceType>) downloadResourceTypeService.findAll();
		model.addAttribute("types", types);
		
		Iterable<ResourceSrc> resourceSrcs = resourceSrcService.findAll();
		model.addAttribute("resourceSrcs", resourceSrcs);
		
		return "admin/update_download_resource";
	}
	
	@RequestMapping("admin/deleteDownloadResource")
	public String deleteDownloadResource(Integer id){
		downloadResourceService.delete(id);
		return "redirect:/admin/findDownloadResources";
	}
	
	@RequestMapping("toDownloadResource")
	public String toDownloadResource(Integer pageNumber,Integer pageSize,Short typeId,Model model){
		
		if (pageNumber == null) {
			pageNumber = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}

		Pageable pageable = new PageRequest(pageNumber-1, pageSize);

		Page<DownloadResource> page = null;

		if (typeId == null) {
			page = downloadResourceService.findAll(pageable);
		} else {
			page = downloadResourceService.findAll(pageable, typeId);
		}

		model.addAttribute("page", page);
		
		//获得所有的类型
		Iterable<DownloadResourceType> types = downloadResourceTypeService.findAll();
		model.addAttribute("types", types);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("typeId", typeId);
		
		return "download_resource";
	}
	
	@RequestMapping("toDownloadResourceDetail")
	public String toDownloadResourceDetail(Integer id,Model model){
		
		if(id != null){
			DownloadResource downloadResource = downloadResourceService.findOne(id);
			model.addAttribute("downloadResource", downloadResource);
			
			//获得所有的类型
			Iterable<DownloadResourceType> types = downloadResourceTypeService.findAll();
			model.addAttribute("types", types);
			
			//获得上一个对象
			DownloadResource last = downloadResourceService.getLast(id);
			model.addAttribute("last", last);
			//获得下一个对象
			DownloadResource next = downloadResourceService.getNext(id);
			model.addAttribute("next", next);
		}
		
		return "download_resource_detail";
	}
	
	@RequestMapping("downloadFile")
	public void downloadFile(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		DownloadResource downloadResource = downloadResourceService.findOne(id);
		
		//下载次数加1
		downloadResource.setCount(downloadResource.getCount()+1);
		
		downloadResourceService.save(downloadResource);
		
		String name = downloadResource.getName();
		String realName = downloadResource.getRealName();
		
		realName = new String(realName.getBytes("UTF-8"),"ISO-8859-1");
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-disposition", "attachment;filename="+realName);	
		OutputStream out = response.getOutputStream();	
		String filePath = request.getServletContext().getRealPath("static") + File.separator+"upload"+File.separator+"file";
		File file = new File(filePath, name);
		FileInputStream fis = new FileInputStream(file);	
		byte[] buffer = new byte[1024];	
		int len = 0;	
		while(-1 != (len=fis.read(buffer))){
			out.write(buffer, 0, len);
		}
		fis.close();
		out.close();	
	}
}



