startTeamEngine.bat -mode=test -source=../testdata/DescribeRecord.xml -workdir=work  -logdir=log





#
#Test mode:
#  Use to start a test session.
#
#  startTeamEngine.bat [-mode=test] -source=ctlfile|dir [-source=ctlfile|dir] ...
#
#    [-workdir=dir] [-logdir=dir] [-session=session]
#    [-suite=qname|-test=qname [@param-name=value] ...] [-profile=qname|*] ...
#
#    qname=[namespace_uri,|prefix:]local_name]
#
#Resume mode:
#  Use to resume a test session that was interrupted before completion.
#
#  startTeamEngine.bat -mode=resume -logdir=dir -session=session
#
#Retest mode:
#  Use to reexecute individual tests.
#
#  startTeamEngine.bat -mode=retest -logdir=dir -session=session testpath1 [testp
#ath2] ...
#
#
#
#