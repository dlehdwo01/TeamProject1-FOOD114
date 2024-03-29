package teamProject.food114.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamProject.food114.mapper.BoardMapper;
import teamProject.food114.model.Board;
import teamProject.food114.model.Review;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public HashMap<String, Object> searchEventList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		try {
			List<Board> list = boardMapper.selectEventList(map);
			boardMapper.updateEndYn();
			resultMap.put("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	// 
	@Override
	public HashMap<String, Object> searchEvent(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("board", boardMapper.selectEventView(map));
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "failed");
		}
		return resultMap;
	}

	// 공지사항 게시글 목록, 개수
	@Override
	public HashMap<String, Object> searchBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Board> list = boardMapper.selectBoardList(map);

		int cnt = boardMapper.selectBoardListCnt(map);
		resultMap.put("list", list);
		resultMap.put("cnt", cnt);

		resultMap.put("result", "success");
		return resultMap;
	}

	// 공지사항 게시글 상세보기
	@Override
	public HashMap<String, Object> searchBoardInfo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		try {
			Board board = boardMapper.selectBoardInfo(map); // 게시글 상세 조회
			resultMap.put("info", board);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBizEventList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("list", boardMapper.selectBizEventList(map));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBizEvent(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			List<Board> listBizEvent = boardMapper.selectBizEvent(map);
			resultMap.put("listBizEvent", listBizEvent);
			resultMap.put("result", "success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBizEventView(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Board listBizEventView = boardMapper.selectBizEventView(map);
			resultMap.put("listBizEventView", listBizEventView);
			resultMap.put("result", "success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addBizEventFile(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(boardMapper.selectBizEventFileYn(map) == null) {
				boardMapper.insertBizEventFile(map);
				boardMapper.updateBizEventBoard(map);
			} else {
				boardMapper.updateBizEventFile(map);
				boardMapper.updateBizEventBoard(map);
			}
			resultMap.put("result", "success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> editBizEventBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(boardMapper.selectBizEventBoard(map) != null) {
				boardMapper.updateBizEventBoard(map);
			} else {
				boardMapper.insertBizEventBoard(map);
			}
			resultMap.put("result", "success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBoardListLimit(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			List<Board> limitBoardList = boardMapper.selectBoardListLimit(map);
			boardMapper.updateEndYn();
			resultMap.put("limitBoardList", limitBoardList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	// 공지사항 게시글 작성
	@Override
	public HashMap<String, Object> insertNotice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			boardMapper.insertNotictBoard(map);
			/* resultMap.put("board", board); */
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	// 공지사항 게시글 삭제
	@Override
	public HashMap<String, Object> deleteNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			boardMapper.insertNotictBoard(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			System.out.println(e.getMessage());
		}
		return resultMap;
	}


}