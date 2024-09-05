# メモ帳アプリ



## 本番環境

http://13.208.100.199/Memo/login.html

## データベースの内容

USER = root

PASSWORD = pass

Database = memo_app


table = users
| Field      | Type        | Null | Key | Default           | Extra                                         |
|------------|-------------|------|-----|-------------------|-----------------------------------------------|
| id         | char(10)    | NO   | PRI | NULL              |                                               |
| pass       | varchar(30) | NO   |     | NULL              |                                               |
| user_name  | varchar(40) | NO   |     | NULL              |                                               |
| created_at | timestamp   | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED                             |
| updated_at | timestamp   | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| is_deleted | tinyint(1)  | NO   |     | 0                 |                                               |


table = memos
| Field      | Type         | Null | Key | Default           | Extra                                         |
|------------|--------------|------|-----|-------------------|-----------------------------------------------|
| title      | varchar(100) | NO   |     | NULL              |                                               |
| user_id    | char(10)     | NO   | MUL | NULL              |                                               |
| content    | text         | YES  |     | NULL              |                                               |
| created_at | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED                             |
| updated_at | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| is_deleted | tinyint(1)   | NO   |     | 0                 |                                               |
| memo_id    | int          | NO   | PRI | NULL              | auto_increment                                |
