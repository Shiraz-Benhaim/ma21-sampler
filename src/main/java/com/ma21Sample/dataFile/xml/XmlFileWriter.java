package com.ma21Sample.dataFile.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.exceptions.FailedToWriteDataFileException;
import com.ma21Sample.labTest.LabTestsManager;
import com.ma21Sample.labTest.LabTestsManagerUtils;
import org.apache.log4j.Logger;

import java.io.File;

public class XmlFileWriter extends DataFileWriter {
    final int MAX_RECORDS_IN_XML_FILE = 50000;

    private LabTestsManager labTestsManager;

    public XmlFileWriter(String dstFile, LabTestsManager labTestsManager) {
        super(Logger.getLogger(XmlFileWriter.class), dstFile);
        this.labTestsManager = labTestsManager;
    }

    @Override
    public void writeObjectToDataFile() throws FailedToWriteDataFileException {
        XmlMapper xmlMapper = new XmlMapper();
        LabTestsManagerUtils managerUtils = new LabTestsManagerUtils();
        LabTestsManager[] labTestsManagers;
        String currPathName;

        try {
            labTestsManagers = managerUtils.splitLabTestsManager(this.labTestsManager, MAX_RECORDS_IN_XML_FILE);

            for (int i = 0; i < labTestsManagers.length; i++) {
                currPathName = labTestsManagers.length == 1 ? super.dstFile
                        : super.dstFile.substring(0, super.dstFile.lastIndexOf(".")) + (i + 1) + ".xml";
                xmlMapper.writeValue(new File(currPathName), labTestsManagers[i]);
            }
            super.logger.info("The information was written to the xml file successfully");
        } catch (Exception e) {
            super.logger.error("The information was not written to the xml file");
            throw new FailedToWriteDataFileException(e.getMessage(), e.getCause());
        }
    }
}
