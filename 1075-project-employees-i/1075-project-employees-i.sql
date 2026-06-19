# Write your MySQL query statement below
select p.project_id, round(avg(e.experience_years),2) as average_years from Project p JOIN Employee e On e.employee_id=p.employee_id group by project_id;