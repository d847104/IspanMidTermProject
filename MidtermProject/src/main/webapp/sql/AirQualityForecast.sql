USE [airdb]
GO

/****** Object:  Table [dbo].[AirQualityForecast]    Script Date: 2024/5/23 ¤U¤È 01:12:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AirQualityForecast](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](max) NOT NULL,
	[publishtime] [datetime] NOT NULL,
	[area] [nvarchar](100) NOT NULL,
	[majorpollutant] [nvarchar](100) NULL,
	[forecastdate] [date] NOT NULL,
	[aqi] [int] NOT NULL,
	[minorpollutant] [nvarchar](100) NULL,
	[minorpollutantaqi] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[AirQualityForecast]
ADD [createtime] [datetime] NOT NULL DEFAULT GETDATE()