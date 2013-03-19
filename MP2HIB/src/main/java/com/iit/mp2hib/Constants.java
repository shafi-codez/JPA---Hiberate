/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iit.mp2hib;

/**
 *
 * @author Admin
 */
public class Constants {
    
    public static final String PERSISTANCE_UNIT = "MP2HIB";
    
    public static final String OPTION1 = "Population %increase based on estimate per region per year";
    public static final String OPTION2 = "Max & Min births per state per year";
    public static final String OPTION3 = "Max & Min deaths per state per year";
    public static final String OPTION4 = "Number of states with estimated population increase";
    public static final String OPTION5 = "Number of states with estimated population decrease";
    public static final String OPTION6 = "State with most estimated population per year";
    public static final String OPTION7 = "State with least estimated population per year";
    
    public static final String QUERY1 = "select (NPOPCHG_2010/POPESTIMATE2010)*100 from uscensuspopulationdata where state=0 and name like ";
    public static final String QUERY2 = "select (NPOPCHG_2011/POPESTIMATE2011)*100 from uscensuspopulationdata where state=0 and name like ";
    public static final String QUERY3 = "select BIRTHS2010 from uscensuspopulationdata where name like ";
    public static final String QUERY4 = "select BIRTHS2011 from uscensuspopulationdata where name like ";
    public static final String QUERY5 = "select DEATHS2010 from uscensuspopulationdata where name like ";
    public static final String QUERY6 = "select DEATHS2011 from uscensuspopulationdata where name like ";
    public static final String QUERY7 = "select NPOPCHG_2011-NPOPCHG_2010 from uscensuspopulationdata where state!=0 and name like ";
    public static final String QUERY8 = "select NPOPCHG_2010-NPOPCHG_2011 from uscensuspopulationdata where state!=0 and name like ";
    public static final String QUERY9 = "select name from uscensuspopulationdata where state!=0 order by NPOPCHG_2010 desc limit 1";
    public static final String QUERY10 = "select name from uscensuspopulationdata where state!=0 order by NPOPCHG_2011 desc limit 1";
    public static final String QUERY11 = "select name from uscensuspopulationdata where state!=0 order by NPOPCHG_2010 asc limit 1";
    public static final String QUERY12 = "select name from uscensuspopulationdata where state!=0 order by NPOPCHG_2011 asc limit 1";
    
}