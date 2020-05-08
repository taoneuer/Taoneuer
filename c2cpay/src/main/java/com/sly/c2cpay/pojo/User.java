package  com.sly.c2cpay.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 接受一个参数但不返回，在set方法上使用@JsonProperty,get方法上使用@JsonIgnore
 */
public class User implements Serializable {

  @JsonIgnore
  private Integer id;

  @JsonProperty("user_id")
  private String userId;  //用户名

  @JsonProperty("user_name")
  private String userName;//姓名

  private String userPassword;//密码

  @JsonProperty("student_id")
  private Integer studentId; //学号

  private String major; //专业
  private String institute; //学院
  private String address; //地址
  private Integer certification;
  private Integer trade_num;
  private Integer status;//用户状态

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  @JsonIgnore(value = true)
  public String getUserPassword() {
    return userPassword;
  }

  //接受密码参数但不返回
  @JsonProperty("user_password")
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }


  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }


  public String getInstitute() {
    return institute;
  }

  public void setInstitute(String institute) {
    this.institute = institute;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Integer getCertification() {
    return certification;
  }

  public void setCertification(Integer certification) {
    this.certification = certification;
  }


  public Integer getTradeNum() {
    return trade_num;
  }

  public void setTradeNum(Integer tradeNum) {
    this.trade_num = trade_num;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
