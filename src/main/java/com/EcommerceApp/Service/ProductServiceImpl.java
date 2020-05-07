package com.EcommerceApp.Service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import java.sql.PreparedStatement;
import com.EcommerceApp.Models.Product;
import org.springframework.stereotype.Service;
import com.EcommerceApp.Connection.MySqlConnection;
import com.EcommerceApp.Exception.ProductNotFoundException;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	public static List<Product> prdList = new ArrayList<>();
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	Product prd;

	@Override
	public List<Product> findProductDetail() {
	    String sql = "Select * from productDetail";
		try {
			con = MySqlConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				prd = new Product();
				prd.setPid(rs.getInt("pid"));
				prd.setPrdName(rs.getString("prdName"));
				prd.setPrice(rs.getFloat("price"));
				prdList.add(prd);
			}

		} catch (ClassNotFoundException | SQLException e) {
			//log.error("error --- {}", e);
		}
		//log.info("List of All Products " + prd);
		return prdList;
	}

	@Override
	public void postProduct(Product prd) {
		String sql = "insert into productDetail values(?,?,?) ";
		try {
			con = MySqlConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prd.getPid());
			ps.setString(2, prd.getPrdName());
			ps.setFloat(3, prd.getPrice());
			ps.executeUpdate();
			//log.info("inserted successfully", prd);
		} catch (ClassNotFoundException | SQLException e) {
			//log.error("error --- {}", e);
		}
	}

	@Override
	public void putProduct(int pid, float price) {
		String findSql = "Select * from ProductDetail where pid =? ";
		String sql = "Update productDetail SET price = ? where pid = ?";
		try {
			con = MySqlConnection.getConnection();
			ps = con.prepareStatement(findSql);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new ProductNotFoundException();
			} else {
				ps = con.prepareStatement(sql);
				ps.setInt(1, pid);
				ps.setFloat(3, price);
				ps.executeUpdate();
				//log.info("Updated successfully", ps);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProductByPrice(float price) {
		String sql = "DELETE from productDetail where price = ?";
		try {
			con = MySqlConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			if (rs.next() == false) {
				throw new ProductNotFoundException();
			} else {
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				//log.info("Deleted Successfully", ps);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
