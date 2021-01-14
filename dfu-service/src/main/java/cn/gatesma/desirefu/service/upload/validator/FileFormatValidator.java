
package cn.gatesma.desirefu.service.upload.validator;


import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.service.model.UploadFileModel;

public interface FileFormatValidator {

  public ReturnCode validate(UploadFileModel model);
  
}

