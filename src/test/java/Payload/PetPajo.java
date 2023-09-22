package Payload;

import java.util.List;

import Payload.CategoryPojo;
import Payload.TagsPojo;

public class PetPajo 
{
	    private int id;
		private CategoryPojo Category;
		private String name;
		private List<String> photoUrls;
		private List<TagsPojo> tags;
		private String status;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
		public CategoryPojo getCategory() {
			return Category;
		}
		public void setCategory(CategoryPojo category) {
			Category = category;
		}
		
		
		public List<String> getPhotoUrls() {
			return photoUrls;
		}
		public void setPhotoUrls(List<String> photoUrls) {
			this.photoUrls = photoUrls;
		}
		
		
		public List<TagsPojo> getTags() {
			return tags;
		}
		public void setTags(List<TagsPojo> tags) {
			this.tags = tags;
		}
		
		
		
		


}
