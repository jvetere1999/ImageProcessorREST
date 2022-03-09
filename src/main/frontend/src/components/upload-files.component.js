import React, { Component } from "react";
import UploadService from "../service/upload-files.service";
import FileHandler from "./FileHandler";
export default class UploadFiles extends Component {
    constructor(props) {
        super(props);

        this.state = {
            selectedFiles   : undefined,
            currentFile     : undefined,
            progress        : 0,
            message         : "",
            filesInfos      : [],
        };
    }
    selectedFiles(event) {
        this.setState({
            selectedFiles: event.target.files,
        });
    }
    upload() {
        let currentFile = this.state.selectedFiles[0];
        this.setState({
            progress    : 0,
            currentFile : currentFile,
        });
        UploadService.upload(currentFile, (event) => {
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
                filesInfos: files.data,
            });
        })
        .catch(() => {
            this.setState({
                progress    : 0,
                message     : "Could not upload file.",
                currentFile : undefined,
            });
        });
        this.setState({
            selectedFiles: undefined,
        })
    }
    componentDidMount() {
        UploadService.getFiles().then((response) => {
            this.setState({
                filesInfos: response.data,
            });
        });
    }
    render() {
        const {
            selectedFiles,
            currentFile,
            progress,
            message,
            filesInfos,
        } = this.state;
        return (
            <div>
                {currentFile && (
                <div className="progress">
                    <div
                        className="progress-bar progress-bar-info progress-bar-striped"
                        role="progressbar"
                        aria-valuenow={[progress]}
                        aria-valuemin="0"
                        aria-valuemax="100"
                        style={{ width: progress + "%" }}
                    >
                        {progress}%
                    </div>
                </div>
                )}
                
                <label className="btn btn-default">
                    <input type="file" onChange={this.selectedFile} />
                </label>
                
                <button className="btn btn-success"
                    disabled={!selectedFiles}
                    onClick ={this.upload}
                >
                    Upload
                </button>
                <div className="alert alert-light" role="alert">
                    {message}
                </div>
                <div className="card">
                    <div className  ="card-header">List of Files</div>
                    <ul className   ="list-group list-group-flush">
                        {filesInfos &&
                            filesInfos.map((file, index) => (
                                <li className="list-group-item" key={index}>
                                    <a href={file.url}>{file.name}</a>
                                </li>
                            ))}
                    </ul>
                </div>
            </div>
            
        )
    }
}