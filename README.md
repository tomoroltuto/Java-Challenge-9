# 概要
Java-Challenge-9ではCRUD処理の一つである(Read)読み出しを実装し、データベースに登録しているデータを読み取れるようにしました。
レビューお願いします。

# やったこと

* ①Spring Boot設定
* ②ディレクトリ構成設定
* ③DockerでMySQL構築とSpring Bootとの接続
* ④リクエストでデータ読み取りレスポンスできるように実装
* ⑤実装結果

# ①Spring Boot設定
Spring Bootの設定にはspring initializrを使用して以下の設定しました。

| Project| Gradle Project| 
| :---: | :---: | 
| Language | Java | 
| Spring Boot | 2.7.3 | 
| packing | War| 
| Java | 17 | 
| Dependencies | Spring Web <br> MyBatis Framework <br> MySQL Driver <br> |

#  ②ディレクトリ構成設定
```bash
※　一部省略あり
...
├── build.gradle
├── docker-compose.yaml
├── mysql
│    └── sql
│        ├── my.cnf
│        └── user_list.sql
└── src
    └── main
        ├── java
        │    └── com
        │       └── example
        │           └── javachallenge9
        │               ├── JavaChallenge9Application.java
        │               ├── ServletInitializer.java
        │               ├── controller
        │               │   ├── UserController.java
        │               │   └── UserResponse.java
        │               ├── entity
        │               │   └── User.java
        │               ├── mapper
        │               │   └── UserMapper.java
        │               └── service
        │                   ├── UserService.java
        │                   └── UserServiceImpl.java
        └── resources
            ├── application.yml
            ├── static
            └── templates
``` 

# ③DockerでMySQL構築+Spring Bootとの接続
以下のディレクトリとファイルを作成し,Dockerを起動しコンテナ化しました。

* docker-compose.yaml作成

複数のコンテナから成るサービスを構築・実行する手順を自動的にし、管理を容易にする機能ところ

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/docker-compose.yaml#L2-L23

* mysql/sql/my.cnf作成

MySQLの設定ファイル(主に文字化けしないための設定)

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/mysql/sql/my.cnf#L2-L10

* mysql/sql/user_list.sql作成

SQLで記述されたデータを格納しているファイル

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/mysql/sql/user_list.sql#L1-L14

テーブル表

| id | name | teacher |
| :---: | :---: | :---: | 
| 1| エナミコウジ  | Java・AWS |
| 2 | 小山 由人  | Java |
| 3| 戸部拓人 | Java |
| 4 | ウシジマユウタ | AWS | 
| 5 | 中西 悠人 | AWS |


* src/main/resources/application.yml内コード作成

SpringBootとDBを接続する為の情報を記載

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/resources/application.yml#L1-L6

# ④リクエストでデータ読み取りレスポンスできるように実装

src/main/java/com/example/javachallenge9/mapper/UserMapper.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/mapper/UserMapper.java#L1-L21

src/main/java/com/example/javachallenge9/entity/User.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/entity/User.java#L1-L39

src/main/java/com/example/javachallenge9/service/UserService.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/service/UserService.java#L1-L15

src/main/java/com/example/javachallenge9/service/UserServiceImpl.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/service/UserServiceImpl.java#L1-L31

src/main/java/com/example/javachallenge9/controller/UserController.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/controller/UserController.java#L1-L39

src/main/java/com/example/javachallenge9/controller/UserResponse.java内に以下のコードを作成

https://github.com/tomoroltuto/Java-Challenge-9/blob/6a5cc3060fabd7689b53d81d7eb7a896873a0911/src/main/java/com/example/javachallenge9/controller/UserResponse.java#L1-L39

# ⑤実装結果

リクエストとレスポンスの結果を以下にまとめます

* localhost:8080にアクセスするとDBに登録されている全ての情報ををレスポンスとして返す。

<img width="1440" alt="スクリーンショット 2022-09-07 23 20 15" src="https://user-images.githubusercontent.com/90845405/188929623-da19b478-2bed-4f90-a649-e039c98b6b9f.png">

* localhost:8080/users/2にアクセスするとDBに登録されているId=2の情報をレスポンスとして返す。

<img width="1440" alt="スクリーンショット 2022-09-07 23 20 37" src="https://user-images.githubusercontent.com/90845405/188929648-0bce4d16-92db-41de-a72e-e3e9e3cea459.png">

* localhost:8080/users?teacher=Java にアクセスするとDBに登録されているJavaの講師の情報をレスポンスとして返す。

<img width="1440" alt="スクリーンショット 2022-09-07 23 21 02" src="https://user-images.githubusercontent.com/90845405/188929676-8ec2f166-f93f-4990-9b95-a58cb02bcf51.png">

# 開発環境
IntelliJ IDEA 2022.2.1 (Community Edition)
