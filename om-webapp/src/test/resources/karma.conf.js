module.exports = function(config) {
	config.set({
		basePath : '../../../',
		frameworks : [ 'cucumberjs' ],
		files : [
		{
			pattern : 'node_modules/karma-cucumberjs/vendor/cucumber-html.css',
			watched : false,
			included : false,
			served : true
		}, {
			pattern : 'src/main/webapp/app.template',
			watched : false,
			included : false,
			served : true
		}, {
			pattern : 'src/test/features/**/*.feature',
			watched : true,
			included : false,
			served : true
		}, {
			pattern : 'src/test/features/step_definitions/**/*.js',
			watched : true,
			included : true,
			served : true
		} ],
		exclude : [],
		preprocessors : {
			'src/main/webapp/resources/js/**/*.js' : [ 'coverage' ]
		},
		reporters : [ 'progress', 'coverage' ],
		port : 9876,
		colors : true,
		logLevel : config.LOG_INFO,
		autoWatch : true,
		browsers : [ 'PhantomJS' ],
		singleRun : false,
		plugins : [ 'karma-jasmine', 'karma-cucumberjs',
				'karma-chrome-launcher', 'karma-phantomjs-launcher',
				'karma-junit-reporter', 'karma-coverage' ],
		coverageReporter : {
			type : 'html',
			dir : 'target/coverage/'
		}
	});
};