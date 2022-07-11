package com.example.cmritplacementapp;

public class DriveModel {
        private String companyName;
        private String Role;
        private String CTC;
        private String JD;
        private String Link;
        private int id;
        public String getCompanyName() {
            return companyName;
        }
        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
        public String getRole() {
            return Role;
        }
        public void setRole(String Role) {
            this.Role = Role;
        }
        public String getCTC() {
            return CTC;
        }
        public void setCTC(String CTC) {
            this.CTC = CTC;
        }
        public String getJD() {
            return JD;
        }
        public void setJD(String JD) {
            this.JD = JD;
        }
        public String getLink() {
            return Link;
        }
        public void setLink(String Link) {
            this.Link = Link;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        // constructor
        public DriveModel(String companyName, String Role, String CTC, String JD, String Link) {
            this.companyName = companyName;
            this.Role = Role;
            this.CTC = CTC;
            this.JD = JD;
            this.Link = Link;
        }
    }
