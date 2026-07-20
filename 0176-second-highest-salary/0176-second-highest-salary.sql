# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT salary
    FROM employee
    ORDER BY salary desc
    limit 1 offset 1

)AS SecondHighestSalary;