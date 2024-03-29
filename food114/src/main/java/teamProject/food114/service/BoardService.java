package teamProject.food114.service;

import java.util.HashMap;

public interface BoardService {

	// 이벤트 목록
	HashMap<String, Object> searchEventList(HashMap<String, Object> map);

	// 이벤트 상세보기
	HashMap<String, Object> searchEvent(HashMap<String, Object> map);

	// 공지사항 목록
	HashMap<String, Object> searchBoardList(HashMap<String, Object> map);

	// 공지사항 게시글 상세보기
	HashMap<String, Object> searchBoardInfo(HashMap<String, Object> map);
	
	// 공지사항 게시글 작성
	HashMap<String, Object> insertNotice(HashMap<String, Object> map);
	
	// 공지사항 게시글 삭제
	HashMap<String, Object> deleteNoticeList(HashMap<String, Object> map);

	// Biz 이벤트 목록 출력
	HashMap<String, Object> searchBizEventList(HashMap<String, Object> map);
	
	// 사업자 이벤트 출력
	HashMap<String, Object> searchBizEvent(HashMap<String, Object> map);
	
	HashMap<String, Object> searchBizEventView(HashMap<String, Object> map);
	
	HashMap<String, Object> addBizEventFile(HashMap<String, Object> map);
	
	HashMap<String, Object> editBizEventBoard(HashMap<String, Object> map);
	
	HashMap<String, Object> searchBoardListLimit(HashMap<String, Object> map);
	
}