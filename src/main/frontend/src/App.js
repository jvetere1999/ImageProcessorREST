import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import UploadFiles from './components/upload-files.component';


class App {
  render() {
    return (
    <div className='container' style={{ width: "600px" }}>
      <div style={{ margin: "20px" }}>
        <h3>ImageProcessor</h3>
        <h4>Upload Files</h4>
      </div>
      <UploadFiles />
    </div>
    );
  }
}


export default App;
