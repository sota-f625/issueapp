package in.techcamp.issueapp;

import org.apache.ibatis.annotations.*;

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

    @Select("select * from issues where id = #{id}")
    IssueEntity findById(long id);

    @Update("UPDATE issues SET title = #{title}, content = #{content}, period = #{period}, importance = #{importance} WHERE id = #{id}")
    void update(@Param("id") long id,
                @Param("title") String title,
                @Param("content") String content,
                @Param("period") String period,
                @Param("importance") Character importance);

    @Delete("delete from issues where id=#{id}")
    void deleteById(Long id);
}
