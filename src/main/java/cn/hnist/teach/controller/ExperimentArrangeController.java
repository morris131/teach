package cn.hnist.teach.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.ExperimentArrange;
import cn.hnist.teach.service.inter.IExperimentArrangeService;

@Controller
public class ExperimentArrangeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(ExperimentArrangeController.class);
	
	@Resource
	private IExperimentArrangeService experimentArrangeService;
	
	@RequestMapping("admin/findExperimentArranges")
	public String findExperimentArranges(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<ExperimentArrange> page = experimentArrangeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_experiment_arrange";
	}
	
	@RequestMapping("admin/addExperimentArrange")
	public String addExperimentArrange(){
		return "admin/add_experiment_arrange";
	}
	
	@RequestMapping("admin/saveExperimentArrange")
	public String saveExperimentArrange(ExperimentArrange experimentArrange){
		experimentArrangeService.save(experimentArrange);
		return "redirect:/admin/findExperimentArranges";
	}
	
	@RequestMapping("admin/updateExperimentArrange")
	public String updateExperimentArrange(Integer id,Model model){
		
		ExperimentArrange experimentArrange = experimentArrangeService.findOne(id);
		logger.info(experimentArrange.toString());
		model.addAttribute("experimentArrange",experimentArrange);
		return "admin/update_experiment_arrange";
	}
	
	@RequestMapping("admin/deleteExperimentArrange")
	public String deleteExperimentArrange(Integer id){
		experimentArrangeService.delete(id);
		return "redirect:/admin/findExperimentArranges";
	}
	
	///////////////////////////////////////////////////
	@RequestMapping("toExperimentArrange")
	public String toExperimentArrange(Integer id,Model model){
		
		List<ExperimentArrange> experimentArranges = (List<ExperimentArrange>) experimentArrangeService.findAll();
		
		if(null == id){
			id = -1;
			model.addAttribute("experimentArrange", experimentArranges.get(0));
		}
		
		for (ExperimentArrange experimentArrange : experimentArranges) {
			
			if(id == experimentArrange.getId()){
				model.addAttribute("experimentArrange", experimentArrange);
			}

		}
		
		model.addAttribute("experimentArranges", experimentArranges);
		
		return "experiment_arrange";
	}

}



