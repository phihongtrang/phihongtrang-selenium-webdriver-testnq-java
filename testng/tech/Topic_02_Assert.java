package tech;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
	@Test
	public void TC_01() {
		// Thư viện Assert: Kiểm tra tính đúng đắn của dữ liệu
		// Mong đợi nó đúng/ sai/ đầu vào và đầu ra như nhau
		// Bằng null/ khác null/...
		
		String addressCity = "Ho Chi minh";
		
		// Kiểm tra 1 điều kiện mong đợi là đúng
		Assert.assertTrue(addressCity.equals("Ho Chi minh"));
		Assert.assertTrue(addressCity.contains("Chi minh"));
		Assert.assertTrue(addressCity.contains("Ho Chi"));
		Assert.assertTrue(addressCity.contains("minh"));
		Assert.assertTrue(addressCity.contains("Ho Chi minh"), "Address không chứa dữ liệu mong đợi");
		
		// Kiểm tra 1 điều kiện mong đợi là sai 
		Assert.assertFalse(addressCity.contains("Ha Noi"));
		Assert.assertFalse(addressCity.contains("Fa Nang"));
		
		// Kiểm tra dữ liệu đầu vào và đầu ra là như nhau
		Assert.assertEquals(addressCity, "Ho Chi minh");
		Assert.assertEquals(addressCity, "Ha Noi");
		
		Object fullname = null;
		
		Assert.assertNull(fullname);
		
		
	}

}
