package com.wipro.crime.service;
import java.util.List;
import com.wipro.crime.bean.CrimeBean;
import com.wipro.crime.dao.CrimeDAO;
public class Administrator {
    CrimeDAO dao = new CrimeDAO();
    public String addRecord(CrimeBean bean) {
        String caseId = "CR" + (int)(Math.random() * 100000);
        bean.setCaseId(caseId);
        boolean result = dao.addCrime(bean);
        if (result)
            return "SUCCESS";
        else
            return "FAIL";
    }
    public CrimeBean viewCrime(String title, java.util.Date date) {
        return dao.viewCrime(title, date);
    }
    public List<CrimeBean> viewAllCrimes() {
        return dao.viewAllCrimes();
    }
}