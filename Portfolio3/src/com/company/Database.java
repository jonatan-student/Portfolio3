package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    // Private variables for connector and database
    private Connection conn = null;
    private String db = null;

    // Init with test connection
    public Database(String database) {
        System.out.println("Attempting connect to database at: " + database);
        try {
            connect(database);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endConnection();
        }
    }

    private void connect(String database) throws SQLException {
        conn = DriverManager.getConnection(database);
        db = database;
        System.out.println("Database Connected Successfully!");
    }

    // Default method using internal database
    private void connect() throws SQLException {
        if (db != null) {
            connect(db);
        } else {
            System.err.println("Connector error: Internal database missing or not set");
        }
    }

    public void endConnection()
    {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private ResultSet query(String Query) throws SQLException
    {
        connect();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(Query);
    }

    public ArrayList<String> getNames()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Name FROM People");
            while(rs.next())
            {
                String name = rs.getString("Name");
                result.add(name);
                System.out.println(name);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }
    public ArrayList<String> getNameID()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT ID FROM People");
            while(rs.next())
            {
                String nameID = rs.getString("ID");
                result.add(nameID);
                System.out.println(nameID);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getOccupation()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Occupation FROM People");
            while(rs.next())
            {
                String occupation = rs.getString("Occupation");
                result.add(occupation);
                System.out.println(occupation);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getRegistrationPeopleID()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Teacher_Student_ID FROM Registration");
            while(rs.next())
            {
                String PeopleRegID = rs.getString("Teacher_Student_ID");
                result.add(PeopleRegID);
                System.out.println(PeopleRegID);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getRegistrationCourseID()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Course_ID FROM Registration");
            while(rs.next())
            {
                String CourseRegID = rs.getString("Course_ID");
                result.add(CourseRegID);
                System.out.println(CourseRegID);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getCourseID()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Course_ID FROM Courses");
            while(rs.next())
            {
                String CourseID = rs.getString("Course_ID");
                result.add(CourseID);
                System.out.println(CourseID);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getCourseName()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Course_Name FROM Courses");
            while(rs.next())
            {
                String courseName = rs.getString("Course_Name");
                result.add(courseName);
                System.out.println(courseName);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getTimeBlock()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Day_Time FROM Courses");
            while(rs.next())
            {
                String dayTime = rs.getString("Day_Time");
                result.add(dayTime);
                System.out.println(dayTime);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getCourseRooms()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Rooms FROM Courses");
            while(rs.next())
            {
                String courseRooms = rs.getString("Rooms");
                result.add(courseRooms);
                System.out.println(courseRooms);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getCourseMaxStudents()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Max_Students FROM Courses");
            while(rs.next())
            {
                String maxStudents = rs.getString("Max_Students");
                result.add(maxStudents);
                System.out.println(maxStudents);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    public ArrayList<String> getCourseInfo()
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("SELECT Info FROM Courses");
            while(rs.next())
            {
                String courseInfo = rs.getString("Info");
                result.add(courseInfo);
                System.out.println(courseInfo);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }


}
