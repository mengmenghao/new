package com.cn.service;

import java.util.List;

import com.cn.dao.NewsDao;
import com.cn.vo.News;


public class NewsService {
	NewsDao nDao= null;

	public NewsService() {
		nDao = new NewsDao();
	}
	public List<News> getAllNews(String xuz,String query){
		return nDao.getAllNews(xuz,query);
	}
	public int updateNews(News n) {
		return nDao.updateNews(n);
	}
	public int deleteNews(int id) {
		return nDao.DeletNews(id);
	}
	public int AddNews(News n) {
		return nDao.AddNews(n);
	}
	public News getview(int id) {
		return nDao.getview(id);
	}
}
