package in.techcamp.issueapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface IssueRepository {
    @Insert("insert into issues (title, content, period, importance) values (#{title}, #{content}, #{period}, #{importance})")
    void insert(@Param("title") String title,
                @Param("content") String content,
                @Param("period") String period,
                @Param("importance") Character importance);

    @Select("select * from issues")
    List<IssueEntity> findAll();
}
