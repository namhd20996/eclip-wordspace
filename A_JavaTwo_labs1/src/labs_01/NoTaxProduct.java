package labs_01;

public class NoTaxProduct extends Product {
	
	public NoTaxProduct() {
		
	}
	@Override
	public void xuat() {
		System.out.printf("Tên sản phẩm: %s - Giá sản phẩm: %s - Thuế: %.2f \n", this.getName(), this.getPrice(),
				this.getImportTax());
	}
	@Override
	public double getImportTax() {
		return 0;
	}
}
