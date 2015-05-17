package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="download_resource_type")
@NamedQuery(name="DownloadResourceType.findAll", query="SELECT d FROM DownloadResourceType d")
public class DownloadResourceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Short id;

	private String name;

	//bi-directional many-to-one association to DownloadResource
	@OneToMany(mappedBy="downloadResourceType",cascade=CascadeType.REMOVE)
	private List<DownloadResource> downloadResources;

	public DownloadResourceType() {
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DownloadResource> getDownloadResources() {
		return this.downloadResources;
	}

	public void setDownloadResources(List<DownloadResource> downloadResources) {
		this.downloadResources = downloadResources;
	}

	public DownloadResource addDownloadResource(DownloadResource downloadResource) {
		getDownloadResources().add(downloadResource);
		downloadResource.setDownloadResourceType(this);

		return downloadResource;
	}

	public DownloadResource removeDownloadResource(DownloadResource downloadResource) {
		getDownloadResources().remove(downloadResource);
		downloadResource.setDownloadResourceType(null);

		return downloadResource;
	}

	@Override
	public String toString() {
		return "DownloadResourceType [id=" + id + ", name=" + name + "]";
	}
}