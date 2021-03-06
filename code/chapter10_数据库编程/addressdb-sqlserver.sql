if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_relation_person]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[relation] DROP CONSTRAINT FK_relation_person
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[person]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[person]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[book]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[book]
GO

CREATE TABLE [dbo].[person] (
	[personId] [int] IDENTITY (1, 1) NOT NULL ,
	[personName] [varchar] (40) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[nickName] [varchar] (40) COLLATE Chinese_PRC_CI_AS NULL ,	
	[email] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,	
	[mobilePhone] [char] (20) COLLATE Chinese_PRC_CI_AS NULL 
	
) ON [PRIMARY] 
GO


