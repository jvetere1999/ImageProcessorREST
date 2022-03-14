import React, { Component } from "react";
import App from "../App";
import UploadService from "../service/upload-files.service";

export default class UploadImages extends Component {
    constructor(props) {
        super(props);
        
        this.state = {
            currentFile: undefined,
            previewImage: undefined,
            progress: 0,
            message: "",
            imageInfos: [],
        }
    }
    selectFile(event) {
        this.setState({
            currentFile: event.target.files[0],
            previewImage: URL.createObjectURL(event.target.files[0]),
            progress: 0,
            message: ""
        });
    }
    imageGet(event, _file) {
        App.state.curremtComponent = "grid"
        return UploadService.getPackage(_file)
;    }

    upload() {
        this.setState({
            progress: 0,
        });
        UploadService.upload(this.state.currentFile, (event) => {
            this.setState({
                progress: Math.round((100 * event.loaded) / event.total),
            });
        })
            .then((response) => {
                this.setState({
                    message: response.data.message,
                });
                return UploadService.getFiles();
            })
            .then((files) => {
                this.setState({
                    imageInfos: files.data,
                });
            })
            .catch((err) => {
                this.setState({
                    progress: 0,
                    message: "Could not upload the image!",
                    currentFile: undefined,
                });
            });
    }
    componentDidMount() {
        UploadService.getFiles().then((response) => {
            this.setState({
                imageInfos: response.data,
            });
        });
    }
    
    render() {
        const {
            currentFile,
            previewImage,
            progress,
            message,
            imageInfos
        } = this.state;
        return (
            <div>
                <div className="row">
                    <div className="col-8">
                        <label className="btn btn-default p-0">
                            <input type="file" accept="image/*" onChange={(e) => this.selectFile(e)}/>
                        </label>
                    </div>
                    <div className="col-4">
                        <button
                            className="btn btn-success btn-sm"
                            disabled={!currentFile}
                            onClick={(e) => this.upload(e)}
                        >
                        Upload
                        </button>
                    </div>
                </div>
                {currentFile &&(
                    <div className="progress my-3">
                        <div
                            className="progress-bar progress-bar-info progress-bar-striped"
                            role="progressbar"
                            aria-valuenow={progress}
                            aria-valuemin="0"
                            aria-valuemax="100"
                            style={{ width: progress + "%" }}
                        >
                            {progress}%
                        </div>
                    </div>
                )}
                {previewImage && (
                    <div>
                       <img className="preview" src={previewImage} alt="User uploaded image"/>
                    </div>
                )}
                {message && (
                    <div className="alert alert-secondary mt-3" role="alert">
                        {message}
                    </div>
                )}
                <div className="card mt-3">
                    <div className="card-header">List of Files</div>
                    <ul className="list-group list-group-flush">
                        {imageInfos &&
                            imageInfos.map((img, index) => (
                                <li className="list-group-item" key={index}>
                                    <a href='/files/{img.name}/grid' onClick={(e) => this.imageGet(e, img.url)}>{img.name}</a>
                                </li>
                            ))}
                    </ul>
                </div>
            </div>
        )
    }

}