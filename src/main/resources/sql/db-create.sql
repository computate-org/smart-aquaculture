
CREATE TABLE IF NOT EXISTS CrowdFlowObserved();
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS name text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS description text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS location point;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS areaServed polygon;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS id text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS ngsildTenant text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS ngsildPath text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS ngsildContext text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS ngsildData jsonb;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS address jsonb;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS alternateName text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS averageCrowdSpeed decimal;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS averageHeadwayTime decimal;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS congested boolean;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dataProvider text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dateCreated text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dateModified text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dateObserved text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dateObservedFrom text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS dateObservedTo text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS direction text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS occupancy decimal;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS owner jsonb;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS peopleCount decimal;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS refRoadSegment text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS seeAlso text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS source text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE CrowdFlowObserved ADD COLUMN IF NOT EXISTS displayPage text;

CREATE TABLE IF NOT EXISTS FeedingOperation();
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS category jsonb;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS dataProvider text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS dateCreated text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS dateModified text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS endpoint text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS hasProvider text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS owner jsonb;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS relatedSource jsonb;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS seeAlso text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS source text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS version text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS name text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS description text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS location point;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS areaServed polygon;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS id text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS ngsildTenant text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS ngsildPath text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS ngsildContext text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS ngsildData jsonb;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS address jsonb;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS alternateName text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE FeedingOperation ADD COLUMN IF NOT EXISTS displayPage text;

CREATE TABLE IF NOT EXISTS FishPopulation();
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS name text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS description text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS location point;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS areaServed polygon;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS id text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS ngsildTenant text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS ngsildPath text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS ngsildContext text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS ngsildData jsonb;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS address jsonb;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS alternateName text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS bodyMasse decimal;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS dataProvider text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS dateCreated text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS dateModified text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS fishRemoved decimal;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS initialNumber decimal;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS owner jsonb;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS refSpecie decimal;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS relatedSource jsonb;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS seeAlso text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS source text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS culturedIn decimal;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE FishPopulation ADD COLUMN IF NOT EXISTS displayPage text;

CREATE TABLE IF NOT EXISTS Feed();
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS name text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS description text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS location point;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS areaServed polygon;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS id text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS ngsildTenant text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS ngsildPath text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS ngsildContext text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS ngsildData jsonb;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS address jsonb;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS dataProvider text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS dateCreated text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS dateModified text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS owner jsonb;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS relatedSource jsonb;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS seeAlso text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS source text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS alternateName text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE Feed ADD COLUMN IF NOT EXISTS displayPage text;

CREATE TABLE IF NOT EXISTS Feeder();
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS areaServed polygon;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS id text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS ngsildTenant text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS ngsildPath text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS ngsildContext text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS ngsildData jsonb;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS address jsonb;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS alternateName text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS dataProvider text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS dateCreated text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS dateModified text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS owner jsonb;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS relatedSource jsonb;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS seeAlso text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS source text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS location point;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS name text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS description text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE Feeder ADD COLUMN IF NOT EXISTS displayPage text;

CREATE TABLE IF NOT EXISTS SiteUser();
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userId text UNIQUE;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userName text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userEmail text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userFirstName text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userLastName text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userFullName text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS seeArchived boolean;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS displayName text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS pk bigserial primary key;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS created timestamp with time zone;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS archived boolean;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS sessionId text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS userKey bigint;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS title text;
ALTER TABLE SiteUser ADD COLUMN IF NOT EXISTS displayPage text;
