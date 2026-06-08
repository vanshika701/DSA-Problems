# Write your MySQL query statement below
select author_id as Id from Views group by author_id,viewer_id having author_id=viewer_id order by Id;