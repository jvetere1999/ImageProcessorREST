import React from 'react';
import "./style/App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import UploadImages from './components/image-upload.component';;
import PixelGrid from "react-pixel-grid";


function App() {
    return (
      <div className='container' style={{ width: "600px" }}>
        <div style={{ margin: "20px" }}>
          <h3>ImageProcessor</h3>
          <h4>Upload Files</h4>
        </div>
        <UploadImages/>
          <PixelGrid
              data={Array(64).fill(0).map(Math.random)}
              options={{
                  size: 10,
                  padding: 2,
                  background: [0, 0.5, 1],
              }}
          />
      </div>
      );
}
export default App;

