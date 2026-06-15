package com.ui.pojo;

    public class UserData {
        private String UserName;
        private String Password;

        public String getUserName() {
            return UserName;
        }
        public void setUserName(String userName) {
            UserName = userName;
        }

        public UserData(String userName, String password) {
            UserName = userName;
            Password = password;
        }

        public String getPassword() {
            return Password;
        }
        public void setPassword(String password) {
            Password = password;
        }
        @Override
        public String toString() {
            return "UserData [UserName=" + UserName + ", Password=" + Password + "]";
        }

    }
