package com.mbc.projet.dto;

public class ProjectDTO {

		private int productid;
		private String name;
		private int price;
		private String product_desc;
		
		public ProjectDTO() {
			
		}

		public ProjectDTO(int productid, String name, int price, String product_desc) {
			super();
			this.productid = productid;
			this.name = name;
			this.price = price;
			this.product_desc = product_desc;
		}

		public int getProductid() {
			return productid;
		}

		public void setProductid(int productid) {
			this.productid = productid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getProduct_desc() {
			return product_desc;
		}

		public void setProduct_desc(String product_desc) {
			this.product_desc = product_desc;
		}

		@Override
		public String toString() {
			return "ProjectDTO [productid=" + productid + ", name=" + name + ", price=" + price + ", product_desc="
					+ product_desc + "]";
		}
		
		
}
