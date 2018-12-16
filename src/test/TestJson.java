package test;
import java.util.List;

import service.IProductService;
import service.impl.ProductService;

import com.alibaba.fastjson.JSON;

import entity.Cate;
import entity.Product;
/**
 * @version 时间：2018年5月29日 上午8:49:11
 *
 */
public class TestJson {
	public static void main(String[] args) {
		IProductService ps = new ProductService();
		Product p2 = ps.getProductById(591);
		//把对象转字符串
		String js = JSON.toJSONString(p2);
		//System.out.println(" json :"+js);
		// json :{"childId":546,"description":"画册(特价)","fileName":"images/product/1.jpg","id":591,"name":"画册","parentId":542,"price":100,"stock":9999}
		List<Cate> clist = ps.getAllCate();
		String js2 = JSON.toJSONString(clist);
		System.out.println("json2:"+js2);
	}
}
