Feature: Studyabroad_Shiksha feature

Scenario Outline: TC0011_StudyabroadShiksha_Functionality
Given Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
And Click Change course_country select box, choose course as BE_Btech and Choose specialization as Computer Science & Engineering
And Select Study destination as USA, UK, Canada and click Update
And In Filters Select IELTS and score as <score> & Below in Exam Accepted
And Total Fees as Max_<totfees>
And Capture the college Names and fees only if it is Engineering  course
When Search the college name in the search box based on low fees
Then Match the IELTS score, course Title and country from the University Page
Examples:
|score|totfees|
|7.5|20L|
