package com.inhall.rvcedepartments.Entity;

public class FacultyListEntity {
    private String name,email,phone;

    public FacultyListEntity(String name, String email, String phone)
    {
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

    public FacultyListEntity() {
    }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name=name;
        }
        public String getEmail()
        {
            return email;
        }
        public void setEmail(String email)
        {
            this.email=email;
        }
        public String getPhone()
        {
            return phone;
        }
        public void setPhone(String phone)
        {
            this.phone=phone;
        }
}
