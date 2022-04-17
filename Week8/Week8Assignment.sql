-- 1. I want to know how many employees with each title were born after 1965-01-01.
-- I've additionally filtered to current employee titles, where to_date > current_date(). 
-- Without that filter to view current titles, the resulting counts summed to 2753, whereas there are only 1879 employees born after 1965-01-01, 
-- and so when counting the number of employees who have held a title it double counts some employees who have held multiple titles. 
-- I am interpretring the prompt as how many employees with each (current) title were born after 1965-01-01
-- To see the higher counts of employees who have ever held each title who were born after 1965-01-01, remove the condition on line 15
-- SELECT 
--     COUNT(employees.emp_no) AS 'Employee Count',
--     title AS 'Title'
-- FROM
--     employees
--         JOIN -- unless specified otherwise we are using INNER JOIN, and so we can just use "JOIN"
--     titles ON employees.emp_no = titles.emp_no
-- WHERE
--     titles.to_date > CURRENT_DATE()
--         AND birth_date > '1965-01-01'
-- GROUP BY title;

-- 2. I want to know the average salary per title.
-- SELECT 
--     FORMAT(AVG(salary), 2) AS 'Average Salary', title AS 'Title'
-- FROM
--     employees
--         JOIN
--     titles ON employees.emp_no = titles.emp_no
--         JOIN
--     salaries ON employees.emp_no = salaries.emp_no
-- WHERE
--     salaries.to_date > CURRENT_DATE()
-- GROUP BY title;

-- 3. How much money was spent on salary for the marketing department between the years 1990 and 1992?
-- I am interpreting the date range as 1990-1992 inclusive: 1990-01-01 >> 1992-12-31
SELECT 
-- For each entry from the joined tables within the date ranges, proportion the salaries to the time range for each salary. 
-- For salary entries that span across 1990-01-01 or 1992-12-31, use TO_DAYS to convert to integer, then Least/Greatest to trim to days within desired range, then FROM_DAYS to convert back to date
-- Then use DATEDIFF() to get day-span, divide by 365 and multiply by salary to get money spent. Sum over all entries, group by department. Note, this will exclude the Department Manager's salary for each department. 
-- The department management salaries for the time range can be obtained using a similar query, but join dept_manager instead of dept_emp. The Marketing Department manager salary for the time range was: $493,115.71
    FORMAT(SUM(DATEDIFF(FROM_DAYS(LEAST(TO_DAYS(S.to_date),
                                TO_DAYS('1992-12-31'))),
                FROM_DAYS(GREATEST(TO_DAYS(S.from_date),
                                TO_DAYS('1990-01-01')))) * S.salary / 365),
        2) AS 'Department Employee Salaries',
    D.dept_name
FROM
    employees E
        JOIN
    dept_emp DE ON E.emp_no = DE.emp_no
        JOIN
    departments D ON DE.dept_no = D.dept_no
        JOIN
    salaries S ON E.emp_no = S.emp_no
WHERE
    S.from_date < '1992-12-31'
        AND S.to_date > '1990-01-01'        
GROUP BY D.dept_no
ORDER BY D.dept_no;





