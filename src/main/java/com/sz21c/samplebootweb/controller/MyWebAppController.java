package com.sz21c.samplebootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sz21c.samplebootweb.model.LocationModel;
import com.sz21c.samplebootweb.persistence.MyWebAppPersistence;

/**
 * 
 * <pre>
 * http로 들어온 요청을 처리하는 class.
 * 
 * Model2로 구현되어 있으며, 서비스 Layer없이 Controller가 바로 Persistence와 연결되는 구조를 가진다.
 * 
 * Slipp Clojure 스터디 1차의 my-webapp 소스에서 handler.clj의 역할을 한다.
 * 페이지 별 주석을 달지는 않지만 jsp는 views.clj의 역할을 한다.
 * </pre>
 *
 * @author 이승철 <scin21c@gmail.com>
 * @since 2015. 5. 11.
 *
 */
@Controller
public class MyWebAppController {

	@Autowired
	private MyWebAppPersistence myWebAppPersistence;
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gamil.com>
	 *
	 * root contextpath를 처리한다.
	 * 기본 home 페이지를 노출한다.
	 * </pre>
	 *
	 * @since 2015. 5. 11.
	 * @return home 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() throws Exception {
		ModelAndView mav = new ModelAndView("home-page");
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 좌표를 입력하는 페이지 호출을 처리한다.
	 * </pre>
	 *
	 * @since 2015. 5. 11.
	 * @return 페이지 입력 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/add-location", method = RequestMethod.GET)
	public ModelAndView addLocationPage() throws Exception {
		ModelAndView mav = new ModelAndView("add-location-page");
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 좌표를 저장한다.
	 * add-location http 호출에 대해 POST method로 요청이 오는 경우에 x, y 파라메터를 받아 DB에 저장한 후,
	 * 저장 결과 페이지를 반환한다.
	 * </pre>
	 *
	 * @since 2015. 5. 11.
	 * @return 저장 결과 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/add-location", method = RequestMethod.POST)
	public ModelAndView addLocationResultsPage(
			@RequestParam(required = true) Integer x,
			@RequestParam(required = true) Integer y
			) throws Exception {
		ModelAndView mav = new ModelAndView("add-location-results-page");
		
		LocationModel location = new LocationModel();
		location.setX(x);
		location.setY(y);
		
		int rowCnt = myWebAppPersistence.addLocationToDb(location);
		
		mav.addObject("locId", location.getId());
		mav.addObject("x", x);
		mav.addObject("y", y);
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 저장된 좌표를 출력하는 페이지를 반환한다.
	 * </pre>
	 *
	 * @since 2015. 5. 11.
	 * @param locId
	 * @return 좌표 열람 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/location/{locId}", method = RequestMethod.GET)
	public ModelAndView locationPage(
			@PathVariable Integer locId
			) throws Exception {
		ModelAndView mav = new ModelAndView("location-page");
		
		LocationModel location = myWebAppPersistence.getXy(locId);

		mav.addObject("locId", locId);
		mav.addObject("x", location.getX());
		mav.addObject("y", location.getY());
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 저장된 모든 좌표의 리스트를 보여주는 페이지를 반환한다.
	 * </pre>
	 *
	 * @since 2015. 5. 11.
	 * @return 저장된 좌표 리스트 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/all-locations", method = RequestMethod.GET)
	public ModelAndView allLocationsPage() throws Exception {
		ModelAndView mav = new ModelAndView("all-locations-page");
		
		List<LocationModel> locationList = myWebAppPersistence.getAllLocations();
		
		mav.addObject("locationList", locationList);
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 좌표 수정 페이지를 반환한다.
	 * </pre>
	 *
	 * @since 2015. 5. 12.
	 * @param locId
	 * @return 좌표 수정 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify-location-view/{locId}", method = RequestMethod.GET)
	public ModelAndView modifyLocViewPage(
			@PathVariable Integer locId
			) throws Exception {
		ModelAndView mav = new ModelAndView("modify-loc-view-page");
		
		LocationModel location = myWebAppPersistence.getXy(locId);
		
		mav.addObject("locId", locId);
		mav.addObject("x", location.getX());
		mav.addObject("y", location.getY());
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 좌표를 수정한다.
	 * </pre>
	 *
	 * @since 2015. 5. 12.
	 * @param locId
	 * @param x
	 * @param y
	 * @return 좌표 수정 결과 페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify-location", method = RequestMethod.POST)
	public ModelAndView modifyLocResultViewPage(
			@RequestParam(required = true) Integer locId,
			@RequestParam(required = true) Integer x,
			@RequestParam(required = true) Integer y
			) throws Exception {
		ModelAndView mav = new ModelAndView("modify-loc-result-view-page");
		
		LocationModel location = new LocationModel();
		location.setId(locId);
		location.setX(x);
		location.setY(y);
		
		myWebAppPersistence.updateLocation(location);
		
		LocationModel rtnLocation = myWebAppPersistence.getXy(locId);
		
		mav.addObject("locId", locId);
		mav.addObject("x", rtnLocation.getX());
		mav.addObject("y", rtnLocation.getY());
		
		return mav;
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * 좌표를 삭제한다.
	 * </pre>
	 *
	 * @since 2015. 5. 12.
	 * @param locId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete-location/{locId}", method = RequestMethod.GET)
	public ModelAndView deleteLocationPage(
			@PathVariable Integer locId
			) throws Exception {
		ModelAndView mav = new ModelAndView("delete-location-page");
		
		myWebAppPersistence.deleteLocation(locId);
		
		mav.addObject("locId", locId);
		
		return mav;
	}
	
}
