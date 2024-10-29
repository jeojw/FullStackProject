import 'package:flutter/scheduler.dart';

import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'package:diet_planner/flutter_flow/custom_functions.dart' as functions;
import 'home_page_model.dart';
export 'home_page_model.dart';

class HomePageWidget extends StatefulWidget {
  const HomePageWidget({super.key});

  @override
  State<HomePageWidget> createState() => _HomePageWidgetState();
}

class _HomePageWidgetState extends State<HomePageWidget> {
  late HomePageModel _model;

  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    _model = createModel(context, () => HomePageModel());

    // On page load action.
    SchedulerBinding.instance.addPostFrameCallback((_) async {
      _model.apiResultw07 = await GetDietListCall.call();
      if ((_model.apiResultw07?.succeeded ?? true)) {
        FFAppState().DietList =
            (_model.apiResultw07?.jsonBody ?? '')
                .toList()
                .cast<dynamic>();
        safeSetState(() {});
      }
      _model.apiResultw1o = await GetInfoDataCall.call();
      if ((_model.apiResultw1o?.succeeded ?? true)) {
        FFAppState().BirthText = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.birth''',
        ).toString();
        FFAppState().Gender = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.gender''',
        )!;
        FFAppState().Age = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.age''',
        )!;
        FFAppState().Height = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.height''',
        )!;
        FFAppState().Weight = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.weight''',
        )!;
        FFAppState().ActiveCoef = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.activeCoef''',
        )!;
        FFAppState().BMR = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.bmr''',
        )!;
        FFAppState().DietList = getJsonField(
          (_model.apiResultw1o?.jsonBody ?? ''),
          r'''$.dietList''',
        )!;
        safeSetState(() {});
      }
    });
  }

  @override
  void dispose() {
    _model.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    context.watch<FFAppState>();

    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        key: scaffoldKey,
        backgroundColor: FlutterFlowTheme.of(context).primaryBackground,
        appBar: AppBar(
          backgroundColor: FlutterFlowTheme.of(context).primary,
          automaticallyImplyLeading: false,
          title: Text(
            'Diet Planner',
            style: FlutterFlowTheme.of(context).headlineMedium.override(
                  fontFamily: 'Inter Tight',
                  color: Colors.white,
                  fontSize: 22.0,
                  letterSpacing: 0.0,
                ),
          ),
          actions: [],
          centerTitle: false,
          elevation: 2.0,
        ),
        body: SafeArea(
          top: true,
          child: Column(
            mainAxisSize: MainAxisSize.max,
            children: [
              Padding(
                padding: EdgeInsetsDirectional.fromSTEB(55.0, 50.0, 0.0, 70.0),
                child: FFButtonWidget(
                  onPressed: () async {
                    var _shouldSetState = false;
                    _model.apiResultc04 = await SearchDietListsCall.call();

                    _shouldSetState = true;
                    if ((_model.apiResultc04?.succeeded ?? true)) {
                      if ((FFAppState().DietList.isNotEmpty) == true) {
                        FFAppState().DietList = [];
                        safeSetState(() {});
                        FFAppState().DietList =
                            (_model.apiResultc04?.jsonBody ?? '')
                                .toList()
                                .cast<dynamic>();
                        safeSetState(() {});
                      } else {
                        FFAppState().DietList =
                            (_model.apiResultc04?.jsonBody ?? '')
                                .toList()
                                .cast<dynamic>();
                        safeSetState(() {});
                      }

                      context.pushNamed('DietList');
                    } else {
                      await showDialog(
                        context: context,
                        builder: (alertDialogContext) {
                          return AlertDialog(
                            title: Text('Search Diet List'),
                            content: Text('API Call failed!'),
                            actions: [
                              TextButton(
                                onPressed: () =>
                                    Navigator.pop(alertDialogContext),
                                child: Text('Ok'),
                              ),
                            ],
                          );
                        },
                      );
                      if (_shouldSetState) safeSetState(() {});
                      return;
                    }

                    if (_shouldSetState) safeSetState(() {});
                  },
                  text: 'Search Diets',
                  options: FFButtonOptions(
                    width: MediaQuery.sizeOf(context).width * 0.7,
                    height: 60.0,
                    padding:
                        EdgeInsetsDirectional.fromSTEB(16.0, 0.0, 16.0, 0.0),
                    iconPadding:
                        EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 0.0),
                    color: FlutterFlowTheme.of(context).primary,
                    textStyle: FlutterFlowTheme.of(context).titleSmall.override(
                          fontFamily: 'Inter Tight',
                          color: Colors.white,
                          fontSize: 24.0,
                          letterSpacing: 0.0,
                        ),
                    elevation: 0.0,
                    borderRadius: BorderRadius.circular(24.0),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsetsDirectional.fromSTEB(50, 0, 0, 70),
                child: FFButtonWidget(
                  onPressed: () async {
                    if (FFAppState().DietList.isNotEmpty){
                      context.pushNamed('DietList');
                    }
                    else{
                      await showDialog(
                        context: context,
                        builder: (alertDialogContext) {
                          return AlertDialog(
                            title: Text('Show Diet List'),
                            content: Text('Current Diet list is empty!'),
                            actions: [
                              TextButton(
                                onPressed: () =>
                                    Navigator.pop(alertDialogContext),
                                child: Text('Ok'),
                              ),
                            ],
                          );
                        },
                      );
                    }
                  },
                  text: 'Show Diets',
                  options: FFButtonOptions(
                    width: MediaQuery.sizeOf(context).width * 0.7,
                    height: 60,
                    padding: EdgeInsetsDirectional.fromSTEB(16, 0, 16, 0),
                    iconPadding: EdgeInsetsDirectional.fromSTEB(0, 0, 0, 0),
                    color: FlutterFlowTheme.of(context).primary,
                    textStyle: FlutterFlowTheme.of(context).titleSmall.override(
                          fontFamily: 'Inter Tight',
                          color: Colors.white,
                          fontSize: 24,
                          letterSpacing: 0.0,
                        ),
                    elevation: 0,
                    borderRadius: BorderRadius.circular(24),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsetsDirectional.fromSTEB(50.0, 0.0, 0.0, 0.0),
                child: FFButtonWidget(
                  onPressed: () async {
                    context.pushNamed('SetOptions');
                  },
                  text: 'Set Options',
                  options: FFButtonOptions(
                    width: MediaQuery.sizeOf(context).width * 0.7,
                    height: 60.0,
                    padding:
                        EdgeInsetsDirectional.fromSTEB(16.0, 0.0, 16.0, 0.0),
                    iconPadding:
                        EdgeInsetsDirectional.fromSTEB(0.0, 0.0, 0.0, 0.0),
                    color: FlutterFlowTheme.of(context).primary,
                    textStyle: FlutterFlowTheme.of(context).titleSmall.override(
                          fontFamily: 'Inter Tight',
                          color: Colors.white,
                          fontSize: 24.0,
                          letterSpacing: 0.0,
                        ),
                    elevation: 0.0,
                    borderRadius: BorderRadius.circular(24.0),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}