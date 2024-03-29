package teamProject.food114.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamProject.food114.mapper.BizMapper;
import teamProject.food114.mapper.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	@Autowired
	BizMapper bizMapper;

	@Override
	public HashMap<String, Object> searchCategory(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("categoryList", menuMapper.selectCategory(map));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	// 메뉴 검색
	@Override
	public HashMap<String, Object> searchMenuList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("menuList", menuMapper.selectMenuList(map));
			resultMap.put("menuCnt", menuMapper.selectMenuCount(map));
			if(bizMapper.selectEventStatus(map)!=null) {
				resultMap.put("eventStatus", bizMapper.selectEventStatus(map).getEventStatus());
			}
			
			resultMap.put("saleList", menuMapper.selectSalePrice(map));
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	// 선택한 메뉴 검색
	@Override
	public HashMap<String, Object> searchMenu(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("menu", menuMapper.selectMenu(map));
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "fail");
			System.out.println(e.getMessage());
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addMenu(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			menuMapper.insertMenu(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addMenuNoFile(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			menuMapper.insertMenuNoFile(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchMenuView(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			resultMap.put("menuView", menuMapper.selectMenuView(map));
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> editMenu(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			menuMapper.updateMenu(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> editMenuNoFile(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String,Object> resultMap = new HashMap<>();
		try {
			menuMapper.updateMenuNoFile(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> editSalePrice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String,Object> resultMap = new HashMap<>();
		try {
			menuMapper.updateSalePrice(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addSalePrice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String,Object> resultMap = new HashMap<>();
		try {
			menuMapper.insertSalePrice(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> removeSalePrice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String,Object> resultMap = new HashMap<>();
		try {
			menuMapper.deleteSalePrice(map);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
}