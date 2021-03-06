package shop.park.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.park.model.Notice;
import shop.park.repository.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> selectAllNotice() {
		List<Notice> noticeList = noticeMapper.selectAllNotice();
		if(noticeList.isEmpty() || noticeList == null) {
			return null;
		} else {
			return noticeList;
		}
	}

	@Override
	public List<Notice> selectByNoticeCategory(String n_category) {
		List<Notice> noticeCategoryList = noticeMapper.selectByNoticeCategory(n_category);
		
		if(noticeCategoryList.isEmpty() || noticeCategoryList == null) {
			return null;
		} else {
			return noticeCategoryList;
		}
	}

	@Override
	public Notice selectByNoticeNo(long n_no) {
		Notice notice = noticeMapper.selectByNoticeNo(n_no);
		
		if(notice != null) {
			return notice;
		} else {
			return null;
		}
	}

	@Override
	public List<Notice> searchByNoticeTitle(String n_title) {
		List<Notice> searchNoticeTitle = noticeMapper.searchByNoticeTitle(n_title);
		
		if(searchNoticeTitle.isEmpty() || searchNoticeTitle == null) {
			return null;
		} else {
			return searchNoticeTitle;
		}
	}

	@Override
	public Notice incrementNoticeHits(long n_no) {
		Notice notice = noticeMapper.selectByNoticeNo(n_no);
		increment(notice);
		updateNoticeHits(notice);
		
		return notice;
	}
	
	private void increment(Notice notice) {
		notice.setN_hits(notice.getN_hits() + 1);
	}

	@Override
	public void updateNoticeHits(Notice notice) {
		noticeMapper.updateNoticeHits(notice);
	}

	@Override
	public int createNotice(Notice notice) {
		return noticeMapper.insertNotice(notice);
	}

	@Override
	public int editNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}

	@Override
	public int deleteNotice(long n_no) {
		return noticeMapper.deleteNotice(n_no);
	}
}
