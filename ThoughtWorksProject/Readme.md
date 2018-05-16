# Homework 无人机 提交
## 编译
```shell
$ javac -d bin src/com/yyh/*.java
```

## 运行
```shell
$ java -cp bin com.yyh.UnmanPlane filename index
```

## 运行实例

input.txt

```text
plane1 1 1 1
plane1 1 1 1 1 2 3
plane1 2 3 4 1 1 1
plane1 3 4 5
plane1 1 1 1 1 2 3
```

Command line

```shell
$ java -cp bin com.yyh.UnmanPlane input.txt 2
```

Console output // 正常
```text
plane1 2 3 4 5
```

Command line

```shell
$ java -cp bin com.yyh.UnmanPlane input.txt 4
```

Console output //消息存在，无人机故障
```text
Error: 4
```

Command line

```shell
$ java -cp bin com.yyh.UnmanPlane input.txt 100
```

Console output //消息不存在
```text
Cannot find 100
```


input1.txt

```text
plane1 1 1 1
plane1 1 1 1 1 2 3
plane1 2 3 5 1 1 1
plane1 3 4 5
plane1 1 1 1 1 2 3
```

Command line

```shell
$ java -cp bin com.yyh.UnmanPlane input1.txt 2
```

Console output // 坐标不匹配，无人机故障
```text
Error: 2
```

input2.txt

```text
plane1 1 1 1
plane1 1 1 1 1 2 3
plane1 2 3 4 1 1 1
plane2 3 4 5 1 1 1
plane1 1 1 1 1 2 3
```

Command line

```shell
$ java -cp bin com.yyh.UnmanPlane input2.txt 3
```

Console output // 无人机ID不匹配，故障信息
```text
Error: 3
```
