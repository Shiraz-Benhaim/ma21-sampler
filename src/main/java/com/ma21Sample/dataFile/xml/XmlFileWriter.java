package com.ma21Sample.dataFile.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.exceptions.FailedToWriteDataFileException;
import com.ma21Sample.labTest.LabTestsManager;

import java.io.File;

public class XmlFileWriter extends DataFileWriter {
    private LabTestsManager labTestsManager;

    public XmlFileWriter(String dstFile, LabTestsManager labTestsManager) {
        super(dstFile);
        this.labTestsManager = labTestsManager;
    }

    @Override
    public void writeObjectToDataFile() throws FailedToWriteDataFileException {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            xmlMapper.writeValue(new File(super.dstFile), this.labTestsManager);
        } catch (Exception e) {
            throw new FailedToWriteDataFileException(e.getMessage(), e.getCause());
        }
    }
}
