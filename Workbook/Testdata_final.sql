declare @user_list varchar(100)
set @user_list='anki13'
delete from SS_UserList where list_user=@user_list


insert into SS_UserList(List_User,UserType,Attributes)values(@user_list,1,0)
declare @id varchar(100)
delete from DD_Physician_Lookup where UserName=@user_list
insert into DD_Physician_Lookup(Name,UserName,Active) values('first',@user_list,1)
set @id=(select SS_DD_Physician_ID from DD_Physician_Lookup where UserName=@user_list)
insert into DD_Physician_Roles(SS_DD_Physician_ID,Role)values(@id,'OverReadMD')
declare @User_ID varchar(100)
set @User_ID=(select SS_User_ID from SS_UserList where List_User=@user_list)
insert into SS_UserMembership values(@User_ID,5)
insert into SS_UserMembership values(@User_ID,6)
insert into SS_UserMembership values(@User_ID,9)
insert into SS_UserProperties(SS_User_ID,PropertyName,PropertyValue)values(@User_ID,'Display Name','Dr.Ankita Shah1');
declare @user_list1 varchar(100)
set @user_list1='anki14'
delete from SS_UserList where list_user=@user_list1

insert into SS_UserList(List_User,UserType,Attributes)values(@user_list1,1,0)
declare @id1 varchar(100)
delete from DD_Physician_Lookup where UserName=@user_list1
insert into DD_Physician_Lookup(Name,UserName,Active) values('first',@user_list1,1)
set @id1=(select SS_DD_Physician_ID from DD_Physician_Lookup where UserName=@user_list1)
insert into DD_Physician_Roles(SS_DD_Physician_ID,Role)values(@id1,'OverReadMD')
declare @User_ID1 varchar(100)
set @User_ID1=(select SS_User_ID from SS_UserList where List_User=@user_list1)
insert into SS_UserMembership values(@User_ID1,5)
insert into SS_UserMembership values(@User_ID1,6)
insert into SS_UserMembership values(@User_ID1,9)
insert into SS_UserProperties(SS_User_ID,PropertyName,PropertyValue)values(@User_ID1,'Display Name','Dr.Khushbu Shah1');

declare @Patient_ID varchar(100)
set @Patient_ID='1234567'
delete from demographics where patient_ID=@Patient_ID and SSTouch=10
insert into Demographics(Last_Name, First_Name,Middle_Name,Patient_ID,SSTouch) values('Last1','First1','Middle1',@Patient_ID,10)
 
declare @SS_Event_Admission_ID varchar(100)

declare @SS_Patient_ID varchar(100)
set @SS_Patient_ID=(select SS_Patient_ID from Demographics where Patient_ID=@Patient_ID and SSTouch=10)
insert into Event_Admission(SS_Patient_ID,Account_Number,EventDate, EventTime)values(@SS_Patient_ID,'34567',CONVERT (DATE, GETDATE()),CONVERT (Time, GETDATE()))
set @SS_Event_Admission_ID=(select SS_Event_Admission_ID from Event_Admission where SS_Patient_ID=@SS_Patient_ID)
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,10,'EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'20','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'30','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'40','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'50','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'60','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'70','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'80','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'90','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'100','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'110','EC')
insert into Admit_Orders( SS_Event_Admission_ID,OrderNumber,Modality)values(@SS_Event_Admission_ID,'120','EC');



