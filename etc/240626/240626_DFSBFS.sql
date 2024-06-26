-- 240626
-- 파일트리를 DFS/BFS 순회한다면, DB 쿼리를 어떻게 날려봐야 할지에 대해 탐구(?)
-- 데이터 참고 : https://sqlperformance.com/2020/09/t-sql-queries/fundamentals-of-table-expressions-part-6-recursive-ctes

-- 테이블 생성
CREATE TABLE Employees
(
  empid   INT         NOT NULL,
  mgrid   INT         NULL,
  empname VARCHAR(25) NOT NULL,
  salary  DECIMAL(19,4) NOT NULL,
  PRIMARY KEY (empid),
  CONSTRAINT FK_Employees_Employees FOREIGN KEY (mgrid) REFERENCES Employees(empid),
  CHECK (empid <> mgrid)
);

-- 데이터 삽입
INSERT INTO Employees (empid, mgrid, empname, salary)
VALUES
  (1,  NULL, 'David'  , 10000.00),
  (2,     1, 'Eitan'  ,  7000.00),
  (3,     1, 'Ina'    ,  7500.00),
  (4,     2, 'Seraph' ,  5000.00),
  (5,     2, 'Jiru'   ,  5500.00),
  (6,     2, 'Steve'  ,  4500.00),
  (7,     3, 'Aaron'  ,  5000.00),
  (8,     5, 'Lilach' ,  3500.00),
  (9,     7, 'Rita'   ,  3000.00),
  (10,    5, 'Sean'   ,  3000.00),
  (11,    7, 'Gabriel',  3000.00),
  (12,    9, 'Emilia' ,  2000.00),
  (13,    9, 'Michael',  2000.00),
  (14,    9, 'Didi'   ,  1500.00);

-- 인덱스 생성
CREATE UNIQUE INDEX idx_unc_mgrid_empid
  ON Employees(mgrid, empid);

-- DFS 조회
WITH RECURSIVE FileTree AS (
    SELECT
        empid,
        mgrid,
        empname,
        CAST(empid AS CHAR(200)) AS path,
        CAST(LPAD(empid, 5, '0') AS CHAR(200)) AS sorted_path -- 정렬을 위한 패딩 경로 추가
    FROM Employees
    WHERE empid = 1 -- 루트 노드에서 시작
    UNION ALL
    SELECT
        S.empid,
        S.mgrid,
        S.empname,
        CONCAT(M.path, '/', S.empid) AS path,
        CONCAT(M.sorted_path, '/', LPAD(S.empid, 5, '0')) AS sorted_path -- 경로 갱신
    FROM FileTree AS M
    INNER JOIN Employees AS S
        ON S.mgrid = M.empid
)
SELECT empid, mgrid, empname, path
FROM FileTree
ORDER BY sorted_path; -- 패딩된 경로 기준으로 결과 정렬

-- BFS 조회
WITH RECURSIVE FileTree AS (
    SELECT
        empid,
        mgrid,
        empname
    FROM Employees
    WHERE empid = 1 -- 루트 노드에서 시작
    UNION ALL
    SELECT
        S.empid,
        S.mgrid,
        S.empname
    FROM FileTree AS M
    INNER JOIN Employees AS S
        ON S.mgrid = M.empid
)
SELECT empid, mgrid, empname
FROM FileTree;