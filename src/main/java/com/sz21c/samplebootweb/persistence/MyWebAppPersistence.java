package com.sz21c.samplebootweb.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sz21c.samplebootweb.model.LocationModel;

/**
 * 
 * <pre>
 * MyBatis를 이용한 Persistence Class.
 * 
 * 별도의 구현체 없이 MyBatis Mapper를 이용해 Persistence를 구성하였다.
 * 
 * Slipp Clojure 스터디 1차의 my-webapp 소스에서 db.clj의 역할을 한다.
 * </pre>
 *
 * @author 이승철 <scin21c@gmail.com>
 * @since 2015. 5. 12.
 *
 */
public interface MyWebAppPersistence {

	@Insert("insert into locations(x, y) values (#{x}, #{y})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	public int addLocationToDb(LocationModel location);
	
	@Select("select x, y from locations where id = #{id}")
	public LocationModel getXy(Integer id);
	
	@Select("select id, x, y from locations")
	public List<LocationModel> getAllLocations();
	
	@Update("update locations set x = #{x}, y = #{y} where id = #{id}")
	public int updateLocation(LocationModel location);
	
	@Delete("delete from locations where id = #{id}")
	public int deleteLocation(Integer id);
}
