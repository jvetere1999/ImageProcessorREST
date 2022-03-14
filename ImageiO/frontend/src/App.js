import React from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadFiles from './components/upload-files.component';
import UploadImages from './components/image-upload.component';


function App()  {
  return (
    <div className='container' style={{ width: "600px" }}>
      <div style={{ margin: "20px" }}>
        <h3>ImageProcessor</h3>
        <h4>Upload Files</h4>
      </div>
      <UploadImages />
    </div>
    );
  
}


export default App;
