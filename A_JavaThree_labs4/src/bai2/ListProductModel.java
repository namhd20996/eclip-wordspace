package bai2;

import java.util.ArrayList;

public class ListProductModel {
	private ArrayList<ProductModel> listProduct;
	
	public ListProductModel() {
		this.listProduct = new ArrayList<ProductModel>();
	}

	public ListProductModel(ArrayList<ProductModel> listProduct) {
		this.listProduct = listProduct;
	}

	public ArrayList<ProductModel> getListProduct() {
		return listProduct;
	}

	public void setListProduct(ArrayList<ProductModel> listProduct) {
		this.listProduct = listProduct;
	}
	
	public void insert(ProductModel product) {
		this.listProduct.add(product);
	}
	
	public void delete(ProductModel product) {
		this.listProduct.remove(product);
	}
	
	public void update(int index, ProductModel product) {
		this.listProduct.set(index, product);
	}

	 boolean checkContainer(ProductModel pd) {
		for (ProductModel productModel : listProduct) {
			if(productModel.getMaSP().equals(pd.getMaSP())) {
				return true;
			}
		}
		return false;
	}
}
