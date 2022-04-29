package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    // creates variables for the connection as well as the database
    private Connection conn = null;
    private String db = null;

    // Connecting to the database, using the call and url from Main
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

    //actual connect ;)
    private void connect(String database) throws SQLException {
        conn = DriverManager.getConnection(database);
        db = database;
        System.out.println("Database Connected Successfully!");
    }

    // Issue with connecting message
    private void connect() throws SQLException {
        if (db != null) {
            connect(db);
        } else {
            System.err.println("Connector error: Internal database missing or not set");
        }
    }

    //method to end a connection from the database
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

    //initial query using SQLite commands in Strings that are given to the database to retrieve either an array list or string back
    private ResultSet query(String Query) throws SQLException
    {
        connect();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(Query);
    }

    //ALL USED METHODS FOR GETTING INFO FROM DATABASE BELOW
    //MOST NAMES FOR THE METHODS ARE SELF EXPLANATORY
    //SO ONLY FIRST FUNCTION IS COMMENTED FOR NEEDED UNDERSTANDING

    //method to receive all course names from Database
    public ArrayList<String> getCourseName()
    {
        //create an ArrayList named result
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            //use the query method to send the SQLite command to retrieve information
            ResultSet rs = query("SELECT Course_Name FROM Courses");
            while(rs.next())
            {
                //stores the desired column from the table and then adds it to the ArrayList that is returned
                String courseName = rs.getString("Course_Name");
                result.add(courseName);
                //System.out.println(courseName);   <---- Was used initially for testing to make sure desired output was recieved
            }
        } //if SQLite does not receive proper command then ends
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            endConnection();
        }
        return result;
    }

    //Get Names using an ID
    public String getNameWithID(String ID)
    {
        String result = "";
        try
        {
            ResultSet rs = query("Select Name From People where ID = " + ID);
            while(rs.next())
            {
                String nameWithID = rs.getString("Name");
                result = new StringBuilder().append(nameWithID).toString();
                System.out.println(nameWithID);
            }
        }
        catch (SQLException e)
        {
            endConnection();
        }
        return result;
    }

    //Get names using their Occupation
    public ArrayList<String> getNamesWithOccupation(String occupation)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Name From People where Occupation='" + occupation + "';");
            while(rs.next())
            {
                String peopleOccupations = rs.getString("Name");
                result.add(peopleOccupations);
                System.out.println(peopleOccupations);
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

    //Get Registered course IDs using a persons ID
    public ArrayList<String> getRegCourseIDsWithPeopleID(String peopleID)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Course_ID From Registration where Teacher_Student_ID='" + peopleID + "';");
            while(rs.next())
            {
                String courseIDs = rs.getString("Course_ID");
                result.add(courseIDs);
                System.out.println(courseIDs);
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

    //Get registered peoples IDs using a Course ID
    public ArrayList<String> getRegPeopleIDsWithCourseID(String courseID)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Teacher_Student_ID From Registration where Course_ID ='" + courseID + "';");
            while(rs.next())
            {
                String peopleIDs = rs.getString("Teacher_Student_ID");
                result.add(peopleIDs);
                System.out.println(peopleIDs);
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

    //Get an ID by asking for a name
    public String getIDUsingName(String name) {
        String result = "";
        try {
            ResultSet rs = query("Select ID From People where Name = '" + name + "';");
            while (rs.next()) {
                String IDWithName = rs.getString("ID");
                result = new StringBuilder().append(IDWithName).toString();
                System.out.println(IDWithName);
            }
        } catch (SQLException e) {
            endConnection();
        }
        return result;

    }

    //Get all information inside a course using Peoples IDs
    public ArrayList<String> getAllCourseStuffWithID(String courseID)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Course_Name,Day_Time,Rooms,Max_Students,Info From Courses where Course_ID ='" + courseID + "';");
            while(rs.next())
            {
                String courseName = rs.getString("Course_Name");
                result.add(courseName);
                String dayTime = rs.getString("Day_Time");
                result.add(dayTime);
                String rooms = rs.getString("Rooms");
                result.add(rooms);
                String maxStudents = rs.getString("Max_Students");
                result.add(maxStudents);
                String info = rs.getString("Info");
                result.add(info);
                System.out.println(result);
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

    //Get occupation using a persons ID
    public ArrayList<String> getOccupationWithID(String peopleID)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Occupation From People where ID ='" + peopleID + "';");
            while(rs.next())
            {
                String courseIDs = rs.getString("Occupation");
                result.add(courseIDs);
                System.out.println(courseIDs);
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

    //Get a course ID from a name
    public ArrayList<String> getCourseIDWithName(String courseName)
    {
        ArrayList<String> result = new ArrayList<String>();
        try
        {
            ResultSet rs = query("Select Course_ID From Courses where Course_Name ='" + courseName + "';");
            while(rs.next())
            {
                String courseIDs = rs.getString("Course_ID");
                result.add(courseIDs);
                System.out.println(courseIDs);
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
