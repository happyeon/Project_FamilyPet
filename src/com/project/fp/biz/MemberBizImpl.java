package com.project.fp.biz;

import java.util.List;

import com.project.fp.dao.MemberDao;
import com.project.fp.dao.MemberDaoImpl;
import com.project.fp.dto.MemberDto;
import com.project.fp.dto.PagingDto;
import com.project.fp.security.AES256_str;
import com.project.fp.security.RSA_num;

public class MemberBizImpl implements MemberBiz {

	private MemberDao dao = new MemberDaoImpl();

	@Override
	public List<MemberDto> selectList() {

		List<MemberDto> list = dao.selectList();
		for (MemberDto dto : list) {
			try {
				dto.setMember_password(AES256_str.Decrypt(dto.getMember_password()));
				dto.setMember_name(AES256_str.Decrypt(dto.getMember_name()));
				dto.setMember_email(AES256_str.Decrypt(dto.getMember_email()));
				dto.setMember_phone(AES256_str.Decrypt(dto.getMember_phone()));
				dto.setMember_addr(AES256_str.Decrypt(dto.getMember_addr()));
				dto.setMember_point(RSA_num.decryption(dto.getMember_point()));
				dto.setMember_dr_info(AES256_str.Decrypt(dto.getMember_dr_info()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public List<MemberDto> selectDoctorList() {
		List<MemberDto> doclist = dao.selectDoctorList();
		for (MemberDto dto : doclist) {
			try {
				dto.setMember_password(AES256_str.Decrypt(dto.getMember_password()));
				dto.setMember_name(AES256_str.Decrypt(dto.getMember_name()));
				dto.setMember_email(AES256_str.Decrypt(dto.getMember_email()));
				dto.setMember_phone(AES256_str.Decrypt(dto.getMember_phone()));
				dto.setMember_addr(AES256_str.Decrypt(dto.getMember_addr()));
				dto.setMember_point(RSA_num.decryption(dto.getMember_point()));
				dto.setMember_dr_info(AES256_str.Decrypt(dto.getMember_dr_info()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doclist;
	}
	

	@Override
	public List<MemberDto> selectDoctorListPaging(PagingDto Pdto) {
		// TODO Auto-generated method stub
		List<MemberDto> doclist = dao.selectDoctorListPaging(Pdto);
		for (MemberDto dto : doclist) {
			try {
				dto.setMember_password(AES256_str.Decrypt(dto.getMember_password()));
				dto.setMember_name(AES256_str.Decrypt(dto.getMember_name()));
				dto.setMember_email(AES256_str.Decrypt(dto.getMember_email()));
				dto.setMember_phone(AES256_str.Decrypt(dto.getMember_phone()));
				dto.setMember_addr(AES256_str.Decrypt(dto.getMember_addr()));
				dto.setMember_point(RSA_num.decryption(dto.getMember_point()));
				dto.setMember_dr_info(AES256_str.Decrypt(dto.getMember_dr_info()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doclist;

	}

	@Override

	public MemberDto selectSerch(MemberDto dto) {
		MemberDto searchdto = new MemberDto();
		try {
			searchdto = dao.selectSerch(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchdto;
	}

	@Override
	public MemberDto selectIdSerch(MemberDto dto) {

		MemberDto iddto = new MemberDto();
		try {
			dto.setMember_name(AES256_str.Encrypt(dto.getMember_name()));
			dto.setMember_email(AES256_str.Encrypt(dto.getMember_email()));
			iddto = dao.selectIdSerch(dto);
			iddto.setMember_password(AES256_str.Decrypt(iddto.getMember_password()));
			iddto.setMember_name(AES256_str.Decrypt(iddto.getMember_name()));
			iddto.setMember_email(AES256_str.Decrypt(iddto.getMember_email()));
			iddto.setMember_phone(AES256_str.Decrypt(iddto.getMember_phone()));
			iddto.setMember_addr(AES256_str.Decrypt(iddto.getMember_addr()));
			iddto.setMember_point(RSA_num.decryption(iddto.getMember_point()));
			iddto.setMember_dr_info(AES256_str.Decrypt(iddto.getMember_dr_info()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iddto;
	}
	
	@Override
	public MemberDto selectOne(MemberDto dto) {
		System.out.println("selectOne");
		MemberDto onedto = new MemberDto();
		try {
			dto.setMember_password(AES256_str.Encrypt(dto.getMember_password()));
			System.out.println(dto);
			onedto = dao.selectOne(dto);
			System.out.println(onedto);
			onedto.setMember_password(AES256_str.Decrypt(onedto.getMember_password()));
			onedto.setMember_name(AES256_str.Decrypt(onedto.getMember_name()));
			onedto.setMember_email(AES256_str.Decrypt(onedto.getMember_email()));
			onedto.setMember_phone(AES256_str.Decrypt(onedto.getMember_phone()));
			onedto.setMember_addr(AES256_str.Decrypt(onedto.getMember_addr()));
			onedto.setMember_point(RSA_num.decryption(onedto.getMember_point()));
			onedto.setMember_dr_info(AES256_str.Decrypt(onedto.getMember_dr_info()));
			System.out.println(onedto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return onedto;
	}

	@Override
	public int insert(MemberDto dto) {

		try {
			dto.setMember_password(AES256_str.Encrypt(dto.getMember_password()));
			dto.setMember_name(AES256_str.Encrypt(dto.getMember_name()));
			dto.setMember_email(AES256_str.Encrypt(dto.getMember_email()));
			dto.setMember_phone(AES256_str.Encrypt(dto.getMember_phone()));
			dto.setMember_addr(AES256_str.Encrypt(dto.getMember_addr()));
			dto.setMember_point(RSA_num.encryption(dto.getMember_point()));
			dto.setMember_dr_info(AES256_str.Encrypt(dto.getMember_dr_info()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.insert(dto);
	}

	@Override
	public int delete(String member_id) {

		return dao.delete(member_id);
	}

	@Override
	public int update(MemberDto dto) {

		try {
			dto.setMember_password(AES256_str.Encrypt(dto.getMember_password()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dao.update(dto);
	}

	@Override
	public MemberDto selectDetail(String member_id) {

		MemberDto detaildto = dao.selectDetail(member_id);
		try {
			detaildto.setMember_password(AES256_str.Decrypt(detaildto.getMember_password()));
			detaildto.setMember_name(AES256_str.Decrypt(detaildto.getMember_name()));
			detaildto.setMember_email(AES256_str.Decrypt(detaildto.getMember_email()));
			detaildto.setMember_phone(AES256_str.Decrypt(detaildto.getMember_phone()));
			detaildto.setMember_addr(AES256_str.Decrypt(detaildto.getMember_addr()));
			detaildto.setMember_point(RSA_num.decryption(detaildto.getMember_point()));
			detaildto.setMember_dr_info(AES256_str.Decrypt(detaildto.getMember_dr_info()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detaildto;
		
	}

	@Override
	public int grade_update(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.grade_update(dto);
	}
	
	@Override
	public int mypageupdate(MemberDto dto) {

		try {
			dto.setMember_email(AES256_str.Encrypt(dto.getMember_email()));
			dto.setMember_phone(AES256_str.Encrypt(dto.getMember_phone()));
			dto.setMember_addr(AES256_str.Encrypt(dto.getMember_addr()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dao.mypageupdate(dto);
	}

	@Override
	public int mypagemod(MemberDto dto) {

		try {
			dto.setMember_password(AES256_str.Encrypt(dto.getMember_password()));
			dto.setMember_email(AES256_str.Encrypt(dto.getMember_email()));
			dto.setMember_phone(AES256_str.Encrypt(dto.getMember_phone()));
			dto.setMember_addr(AES256_str.Encrypt(dto.getMember_addr()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dao.mypagemod(dto);
	}

	@Override
	public int myanimalupdate(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.myanimalupdate(dto);
	}







}
