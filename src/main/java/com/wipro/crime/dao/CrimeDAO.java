package com.wipro.crime.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.wipro.crime.bean.CrimeBean;
import com.wipro.crime.util.DBUtil;
public class CrimeDAO {
    public String generateCaseID() {
        return "CR" + System.currentTimeMillis();
    }
    public boolean addCrime(CrimeBean bean) {
        boolean flag = false;
        try (Connection con = DBUtil.getDBConnection()) {
            String sql = "INSERT INTO crime_tb "+"(CASEID, CASETITLE, SUSPECTNAME, CRIMETYPE, CRIMEDATE, LOCATION, REMARKS) "+"VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getCaseId());
            ps.setString(2, bean.getCaseTitle());
            ps.setString(3, bean.getSuspectName());
            ps.setString(4, bean.getCrimeType());
            ps.setDate(5, new java.sql.Date(bean.getCrimeDate().getTime()));
            ps.setString(6, bean.getLocation());
            ps.setString(7, bean.getRemarks());
            int rows = ps.executeUpdate();
            if (rows > 0)
                flag = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
 public CrimeBean viewCrime(String title, java.util.Date date) {
        CrimeBean bean = null;
        try (Connection con = DBUtil.getDBConnection()) {
            String sql = "SELECT * FROM CRIME_TB WHERE CASETITLE=? AND CRIMEDATE=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bean = new CrimeBean();
                bean.setCaseId(rs.getString(1));
                bean.setCaseTitle(rs.getString(2));
                bean.setSuspectName(rs.getString(3));
                bean.setCrimeType(rs.getString(4));
                bean.setCrimeDate(rs.getDate(5));
                bean.setLocation(rs.getString(6));
                bean.setRemarks(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public List<CrimeBean> viewAllCrimes() {
        List<CrimeBean> list = new ArrayList<>();
        try (Connection con = DBUtil.getDBConnection()) {
            String sql = "SELECT * FROM CRIME_TB";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CrimeBean bean = new CrimeBean();
                bean.setCaseId(rs.getString(1));
                bean.setCaseTitle(rs.getString(2));
                bean.setSuspectName(rs.getString(3));
                bean.setCrimeType(rs.getString(4));
                bean.setCrimeDate(rs.getDate(5));
                bean.setLocation(rs.getString(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}