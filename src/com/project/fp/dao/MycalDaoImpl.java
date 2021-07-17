package com.project.fp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.project.fp.dto.MycalDto;

public class MycalDaoImpl extends SqlMapConfig implements MycalDao {
	
	String namespace = "com.project.fp.mycal.";

	@Override
	public List<MycalDto> selectViewList(MycalDto dto) {
		List<MycalDto> list = new ArrayList<MycalDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"selectViewList",dto);
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MycalDto> selectList(MycalDto dto) {
		List<MycalDto> list = new ArrayList<MycalDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"selectList",dto);
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MycalDto selectOne(int cal_no) {
		MycalDto dto = null;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace+"selectOne", cal_no);
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int selectCount(MycalDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.selectOne(namespace+"selectCount",dto);
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertCal(MycalDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.insert(namespace+"insertCal",dto);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertCheck(MycalDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.insert(namespace+"insertCheck",dto);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertNextCheck(MycalDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.insert(namespace+"insertNextCheck",dto);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateCal(MycalDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.update(namespace+"updateCal",dto);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteCal(int cal_no) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.delete(namespace+"deleteCal",cal_no);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<MycalDto> selectAllList() {
		List<MycalDto> list = new ArrayList<MycalDto>();
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"selectAllList");
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateCalChk(int cal_no) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			res = session.delete(namespace+"updateCalChk",cal_no);
			if (res > 0) {
				session.commit();
			}
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
