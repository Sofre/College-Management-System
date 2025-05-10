------ FLOW  RIDERS -------
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collagedata`
-- NOTE: Run on OracleMySQL --> FOR DBA

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `collagename` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `contactnumber` varchar(40) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  `lastlogin` varchar(40) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `instagram` varchar(100) DEFAULT NULL,
  `twitter` varchar(100) DEFAULT NULL,
  `linkedin` varchar(100) DEFAULT NULL,
  `logo` longblob DEFAULT NULL,
  `activestatus` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--



-- --------------------------------------------------------

--
-- Table structure for table `attandance`
--

CREATE TABLE `attandance` (
  `subjectcode` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `rollnumber` bigint(20) DEFAULT NULL,
  `present` tinyint(1) NOT NULL DEFAULT 0,
  `courcecode` varchar(20) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `sr_no` int(11) NOT NULL,
  `fromuserid` varchar(70) DEFAULT NULL,
  `fromusername` varchar(50) DEFAULT NULL,
  `touserid` varchar(70) DEFAULT NULL,
  `message` longtext DEFAULT NULL,
  `messagetime` varchar(20) DEFAULT NULL,
  `messagedate` varchar(40) DEFAULT NULL,
  `readby` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cources`
--

CREATE TABLE `cources` (
  `sr_no` int(11) NOT NULL,
  `Courcecode` varchar(20) DEFAULT NULL,
  `CourceName` varchar(30) DEFAULT NULL,
  `semoryear` varchar(5) DEFAULT NULL,
  `totalsemoryear` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `faculties`
--

CREATE TABLE `faculties` (
  `facultyid` int(11) DEFAULT NULL,
  `facultyname` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `contactnumber` varchar(20) DEFAULT NULL,
  `qualification` varchar(30) DEFAULT NULL,
  `experience` varchar(30) DEFAULT NULL,
  `birthdate` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `profilepic` longblob DEFAULT NULL,
  `courcecode` varchar(20) DEFAULT 'NOT ASSIGNED',
  `semoryear` int(11) DEFAULT 0,
  `subject` varchar(40) DEFAULT 'NOT ASSIGNED',
  `position` varchar(40) DEFAULT 'NOT ASSIGNED',
  `sr_no` int(11) NOT NULL,
  `lastlogin` varchar(100) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `activestatus` tinyint(4) DEFAULT 0,
  `joineddate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `courcecode` varchar(20) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `subjectcode` varchar(20) DEFAULT NULL,
  `subjectname` varchar(40) DEFAULT NULL,
  `rollnumber` bigint(20) DEFAULT NULL,
  `theorymarks` int(11) DEFAULT NULL,
  `practicalmarks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `sr_no` int(11) NOT NULL,
  `userprofile` varchar(30) DEFAULT NULL,
  `courcecode` varchar(30) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `userid` varchar(30) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `readby` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `courcecode` varchar(30) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `isdeclared` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rollgenerator`
--

CREATE TABLE `rollgenerator` (
  `courcecode` varchar(20) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `rollnumber` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Courcecode` varchar(20) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `rollnumber` bigint(20) DEFAULT NULL,
  `optionalsubject` varchar(30) DEFAULT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `contactnumber` varchar(20) DEFAULT NULL,
  `dateofbirth` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `fathername` varchar(20) DEFAULT NULL,
  `fatheroccupation` varchar(30) DEFAULT NULL,
  `mothername` varchar(30) DEFAULT NULL,
  `motheroccupation` varchar(30) DEFAULT NULL,
  `profilepic` longblob DEFAULT NULL,
  `sr_no` int(11) NOT NULL,
  `lastlogin` varchar(100) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `activestatus` tinyint(4) DEFAULT 0,
  `admissiondate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subjectcode` varchar(20) DEFAULT NULL,
  `subjectname` varchar(50) DEFAULT NULL,
  `courcecode` varchar(20) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `subjecttype` varchar(30) DEFAULT NULL,
  `theorymarks` int(11) DEFAULT NULL,
  `practicalmarks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `sr_no` int(11) NOT NULL,
  `courcecode` varchar(30) DEFAULT NULL,
  `semoryear` int(11) DEFAULT NULL,
  `userid` mediumtext DEFAULT NULL,
  `logintime` varchar(100) DEFAULT NULL,
  `userprofile` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `cources`
--
ALTER TABLE `cources`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `faculties`
--
ALTER TABLE `faculties`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`sr_no`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD UNIQUE KEY `subjectcode` (`subjectcode`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`sr_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cources`
--
ALTER TABLE `cources`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `faculties`
--
ALTER TABLE `faculties`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
